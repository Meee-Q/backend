package meQ.backend.domain.dto.membersFoods;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class MembersFoodsResponseDto {
    private Long membersKey;
    private List<String> foodsIds;

    @Builder
    public MembersFoodsResponseDto(Long membersKey, List<String> foodsIds) {
        this.foodsIds = foodsIds;
        this.membersKey = membersKey;
    }
}
