package meQ.backend.domain.dto.membersAllergies;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class MembersAllergiesResponseDto {

    private Long membersKey;
    private List<String> allergiesIds;

    @Builder
    public MembersAllergiesResponseDto(Long membersKey, List<String> allergiesIds) {
        this.allergiesIds = allergiesIds;
        this.membersKey = membersKey;
    }
}
