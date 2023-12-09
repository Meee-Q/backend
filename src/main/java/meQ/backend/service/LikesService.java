package meQ.backend.service;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.dto.likes.LikesSaveRequestDto;
import meQ.backend.domain.dto.restaurants.MembersRestaurantsResponseDto;
import meQ.backend.domain.dto.restaurants.RestaurantsResponseDto;
import meQ.backend.domain.entity.Likes;
import meQ.backend.domain.entity.Members;
import meQ.backend.domain.entity.Restaurants;
import meQ.backend.repository.LikesRepository;
import meQ.backend.repository.MembersRepository;
import meQ.backend.repository.RestaurantsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LikesService {

    private final MembersRepository membersRepository;
    private final RestaurantsRepository restaurantsRepository;
    private final LikesRepository likesRepository;

    private Members findMembers(Long membersKey) {
        return membersRepository.findById(membersKey)
                .orElseThrow(() -> new IllegalArgumentException("there is no [" + membersKey + "] members"));
    }

    private Restaurants findRestaurants(Long restaurantsId) {
        return restaurantsRepository.findById(restaurantsId)
                .orElseThrow(() -> new IllegalArgumentException("there is no [" + restaurantsId + "] restaurants"));
    }

    public void like(LikesSaveRequestDto requestDto) {
        Members members = findMembers(requestDto.getMembersKey());
        Restaurants restaurants = findRestaurants(requestDto.getRestaurantsId());

        Likes likes = Likes.createLikes(members, restaurants);

        likesRepository.save(likes);
    }

    public void unlike(LikesSaveRequestDto requestDto) {
        Members members = findMembers(requestDto.getMembersKey());
        Restaurants restaurants = findRestaurants(requestDto.getRestaurantsId());

        for (Likes likes : members.getLikes()) {
            if (likes.getRestaurants() == restaurants) {
                members.removeLikes(likes);
                break;
            }
        }

        membersRepository.save(members);
    }

    public MembersRestaurantsResponseDto getLikes(Long membersKey) {
        Members members = findMembers(membersKey);
        List<RestaurantsResponseDto> responseDtoList = new ArrayList<>();

        for (Likes likes : members.getLikes()) {
            Restaurants restaurants = findRestaurants(likes.getRestaurants().getRestaurantsId());

            responseDtoList.add(new RestaurantsResponseDto(
                    restaurants.getRestaurantsId(),
                    restaurants.getRestaurantsName(),
                    restaurants.getNumber(),
                    restaurants.getAddress(),
                    restaurants.getLongitude(),
                    restaurants.getLatitude(),
                    restaurants.getUrl(),
                    restaurants.getCategory()
            ));
        }

        return new MembersRestaurantsResponseDto(membersKey, responseDtoList);
    }
}
