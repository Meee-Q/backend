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
public class Restaurants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long restaurantsId;

    @Column
    private String restaurantsName;

    @Column
    private String address;

    @Column
    private String longitude;

    @Column
    private String latitude;

    @Column
    private String number;

    @Column
    private String url;

    @Column
    private String category;

    @OneToMany(mappedBy = "restaurants", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menus> menus = new ArrayList<>();

    @Builder
    public Restaurants(String restaurantsName, String address, String longitude, String latitude, String number, String url, String category) {
        this.restaurantsName = restaurantsName;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.number = number;
        this.url = url;
        this.category = category;
    }

    public static Restaurants createRestaurants(String restaurantsName, String address, String longitude, String latitude, String number, String url, String category) {
        return new Restaurants(restaurantsName, address, longitude, latitude, number, url, category);
    }

    public void addMenus(Menus menus) {
        this.menus.add((menus));
    }

}
