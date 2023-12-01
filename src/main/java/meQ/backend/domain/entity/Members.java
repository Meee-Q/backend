package meQ.backend.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import meQ.backend.domain.dto.members.MembersSaveRequestDto;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "members", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MembersAllergies> allergies = new ArrayList<>();

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

    public void addAllergies(MembersAllergies membersAllergies) {
        this.allergies.add(membersAllergies);
    }

    public void deleteAllAllergies() {
        if (this.getAllergies() != null) {
            allergies.clear();
        }
    }
}
