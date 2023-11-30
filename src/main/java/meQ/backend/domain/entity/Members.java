package meQ.backend.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import meQ.backend.domain.dto.members.MembersSaveRequestDto;

@NoArgsConstructor
@Getter
@Entity
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membersKey;

    @Column
    private String membersId;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String sex;

    @Column
    private String birth;

    @Builder
    public Members(String membersId, String name, String password, String sex, String birth) {
        this.membersId = membersId;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.birth = birth;
    }

    public static Members createMembers(MembersSaveRequestDto requestDto, String password) {
        return new Members(requestDto.getMembersId(), requestDto.getName(), password, requestDto.getSex(), requestDto.getBirth());
    }
}
