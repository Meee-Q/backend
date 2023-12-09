package meQ.backend.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class MenusAllergies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menusAllergiesId;

    @ManyToOne
    @JoinColumn(name = "menusId")
    private Menus menus;

    @OneToOne
    private Allergies allergies;

    @Builder
    public MenusAllergies(Menus menus, Allergies allergies) {
        this.menus = menus;
        this.allergies = allergies;
        menus.addMenusAllergies(this);
    }

    public static MenusAllergies createMenusAllergies(Menus menus, Allergies allergies) {
        return new MenusAllergies(menus, allergies);
    }
}
