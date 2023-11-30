package meQ.backend.domain.dto.members;

import lombok.Builder;
import lombok.Getter;
import meQ.backend.domain.entity.Members;

@Getter
public class MembersResponseDto {

    Long membersKey;
    String membersId;
    String membersName;
    String membersSex;
    String membersBirth;

    @Builder
    public MembersResponseDto(Members members) {
        this.membersKey = members.getMembersKey();
        this.membersId = members.getMembersId();
        this.membersName = members.getName();
        this.membersSex = members.getSex();
        this.membersBirth = members.getBirth();
    }
}
