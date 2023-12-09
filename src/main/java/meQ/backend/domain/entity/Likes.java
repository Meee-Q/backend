package meQ.backend.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likesId;

    @OneToOne
    private Restaurants restaurants;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "membersKey")
    private Members members;

    @Builder
    public Likes(Members members, Restaurants restaurants) {
        this.members = members;
        this.restaurants = restaurants;
        members.addLikes(this);
    }

    public static Likes createLikes(Members members, Restaurants restaurants) {
        return new Likes(members, restaurants);
    }

}
