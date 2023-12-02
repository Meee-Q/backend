package meQ.backend.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Foods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long foodsId;

    @Column
    private String foodsName;

    @Builder
    public Foods(String name) {
        this.foodsName = name;
    }

    public static Foods createFavoriteFoods(String name) {
        return new Foods(name);
    }
}
