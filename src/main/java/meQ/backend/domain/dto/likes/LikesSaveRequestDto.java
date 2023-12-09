package meQ.backend.domain.dto.likes;

import lombok.Getter;

@Getter
public class LikesSaveRequestDto {
    private Long membersKey;
    private Long restaurantsId;
}
