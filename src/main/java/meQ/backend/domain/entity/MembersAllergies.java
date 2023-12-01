package meQ.backend.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class MembersAllergies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membersAllergiesId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "membersKey")
    private Members members;

    @OneToOne
    private Allergies allergies;

    @Builder
    public MembersAllergies(Members members, Allergies allergies) {
        this.members = members;
        this.allergies = allergies;
    }

    public static MembersAllergies createMembersAllergies(Members members, Allergies allergies) {
        return new MembersAllergies(members, allergies);
    }
}
