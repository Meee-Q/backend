package meQ.backend.domain.dto;

import lombok.Getter;
import meQ.backend.domain.entity.Members;

@Getter
public class MembersSaveRequestDto {
    private String membersId;
    private String password;
    private String name;
    private String sex;
    private String birth;
}
