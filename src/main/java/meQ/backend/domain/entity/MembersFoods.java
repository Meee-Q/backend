package meQ.backend.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class MembersFoods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membersFoodsId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "membersKey")
    private Members members;

    @OneToOne
    private Foods foods;

    @Builder
    public MembersFoods(Members members, Foods foods) {
        this.members = members;
        this.foods = foods;
    }

    public static MembersFoods createMembersfoods(Members members, Foods foods) {
        return new MembersFoods(members, foods);
    }
}
