package meQ.backend.domain.dto.membersAllergies;

import lombok.Getter;

import java.util.List;

@Getter
public class MembersAllergiesSaveRequestDto {
    private List<String> allergiesIds;
    private Long membersKey;
}
