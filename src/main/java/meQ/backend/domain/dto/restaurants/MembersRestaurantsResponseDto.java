package meQ.backend.domain.dto.restaurants;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class MembersRestaurantsResponseDto {
    Long membersKey;
    List<RestaurantsResponseDto> responseDtoList;

    @Builder
    public MembersRestaurantsResponseDto(Long membersKey, List<RestaurantsResponseDto> responseDtoList) {
        this.membersKey = membersKey;
        this.responseDtoList = responseDtoList;
    }
}
