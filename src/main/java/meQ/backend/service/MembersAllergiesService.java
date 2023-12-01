package meQ.backend.service;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.dto.membersAllergies.MembersAllergiesResponseDto;
import meQ.backend.domain.dto.membersAllergies.MembersAllergiesSaveRequestDto;
import meQ.backend.domain.entity.Allergies;
import meQ.backend.domain.entity.Members;
import meQ.backend.domain.entity.MembersAllergies;
import meQ.backend.repository.AllergiesRepository;
import meQ.backend.repository.MembersAllergiesRepository;
import meQ.backend.repository.MembersRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MembersAllergiesService {
    private final MembersRepository membersRepository;
    private final AllergiesRepository allergiesRepository;
    private final MembersAllergiesRepository membersAllergiesRepository;

    private Members findMembers(Long membersKey) {
        return membersRepository.findById(membersKey)
                .orElseThrow(() -> new IllegalArgumentException("there is no [" + membersKey + "] members"));
    }

    private Allergies findAllergies(Long allergiesId) {
        return allergiesRepository.findById(allergiesId)
                .orElseThrow(() -> new IllegalArgumentException("there is no [" + allergiesId + "] allergies"));
    }

    public MembersAllergiesResponseDto save(MembersAllergiesSaveRequestDto requestDto) {
        Members members = findMembers(requestDto.getMembersKey());

        for (String allergiesId : requestDto.getAllergiesIds()) {
            Allergies allergies = findAllergies(Long.parseLong(allergiesId));
            MembersAllergies membersAllergies = membersAllergiesRepository.save(MembersAllergies.createMembersAllergies(members, allergies));
            members.addAllergies(membersAllergies);
        }

        return new MembersAllergiesResponseDto(requestDto.getMembersKey(), requestDto.getAllergiesIds());
    }

    public MembersAllergiesResponseDto update(MembersAllergiesSaveRequestDto requestDto) {
        Members members = findMembers(requestDto.getMembersKey());

        // 기존 알레르기 정보 삭제
        members.deleteAllAllergies();

        // 변경 데이터 저장
        membersRepository.save(members);

        return save(requestDto);
    }
}
