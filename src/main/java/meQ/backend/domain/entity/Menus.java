package meQ.backend.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Entity
public class Menus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menusId;

    @Column
    private String menusName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "restaurants_id")
    private Restaurants restaurants;

    @OneToMany(mappedBy = "menus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenusAllergies> menusAllergies = new ArrayList<>();

    @Builder
    public Menus(String name, Restaurants restaurants) {
        this.menusName = name;
        this.restaurants = restaurants;
        restaurants.addMenus(this);
    }

    public static Menus createMenus(String name, Restaurants restaurants) {
        return new Menus(name, restaurants);
    }

    public void addMenusAllergies(MenusAllergies menusAllergies) {
        this.menusAllergies.add(menusAllergies);
    }
}
