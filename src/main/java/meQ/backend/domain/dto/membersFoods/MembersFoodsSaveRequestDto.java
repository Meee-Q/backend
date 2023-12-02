package meQ.backend.domain.dto.membersFoods;

import lombok.Getter;

import java.util.List;

@Getter
public class MembersFoodsSaveRequestDto {
    private List<String> foodsIds;
    private Long membersKey;
}
