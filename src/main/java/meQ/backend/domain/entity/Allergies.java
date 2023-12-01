package meQ.backend.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Allergies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long allergiesId;

    @Column
    private String allergiesName;

    @Builder
    public Allergies(String name) {
        this.allergiesName = name;
    }

    public static Allergies createAllergies(String name) {
        return new Allergies(name);
    }
}
