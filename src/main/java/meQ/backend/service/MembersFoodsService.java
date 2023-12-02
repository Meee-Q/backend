package meQ.backend.service;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.dto.membersAllergies.MembersAllergiesResponseDto;
import meQ.backend.domain.dto.membersFoods.MembersFoodsResponseDto;
import meQ.backend.domain.dto.membersFoods.MembersFoodsSaveRequestDto;
import meQ.backend.domain.entity.Foods;
import meQ.backend.domain.entity.Members;
import meQ.backend.domain.entity.MembersAllergies;
import meQ.backend.domain.entity.MembersFoods;
import meQ.backend.repository.FoodsRepository;
import meQ.backend.repository.MembersFoodRepository;
import meQ.backend.repository.MembersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MembersFoodsService {

    private final MembersRepository membersRepository;
    private final MembersFoodRepository membersFoodRepository;
    private final FoodsRepository foodsRepository;

    private Members findMembers(Long membersKey) {
        return membersRepository.findById(membersKey)
                .orElseThrow(() -> new IllegalArgumentException("there is no [" + membersKey + "] members"));
    }

    private Foods findFoods(Long foodsId) {
        return foodsRepository.findById(foodsId)
                .orElseThrow(() -> new IllegalArgumentException("there is no [" + foodsId + "] foods"));
    }

    public MembersFoodsResponseDto findById(Long membersKey) {
        List<String> foodsIds = new ArrayList<>();
        Members members = findMembers(membersKey);

        for (MembersFoods membersFoods : members.getFoods()) {
            foodsIds.add(String.valueOf(membersFoods.getFoods().getFoodsId()));
        }

        return new MembersFoodsResponseDto(membersKey, foodsIds);
    }

    public MembersFoodsResponseDto save(MembersFoodsSaveRequestDto requestDto) {
        Members members = findMembers(requestDto.getMembersKey());

        for (String foodsId : requestDto.getFoodsIds()) {
            Foods foods = findFoods(Long.parseLong(foodsId));
            MembersFoods membersFoods = membersFoodRepository.save(MembersFoods.createMembersfoods(members, foods));
            members.addFoods(membersFoods);
        }

        return new MembersFoodsResponseDto(requestDto.getMembersKey(), requestDto.getFoodsIds());
    }
}
