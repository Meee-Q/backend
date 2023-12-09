package meQ.backend.domain.dto.restaurants;

import lombok.Builder;
import lombok.Getter;

@Getter
public class RestaurantsResponseDto {
    Long restaurantsId;
    String restaurantsName;
    String restaurantsNumber;
    String restaurantsAddress;
    String restaurantsLongitude;
    String restaurantsLatitude;
    String restaurantsUrl;
    String restaurantsCategory;

    @Builder
    public RestaurantsResponseDto(Long id, String name, String number, String address, String longitude, String latitude, String url, String category) {
        this.restaurantsId = id;
        this.restaurantsName = name;
        this.restaurantsNumber = number;
        this.restaurantsAddress = address;
        this.restaurantsLongitude = longitude;
        this.restaurantsLatitude = latitude;
        this.restaurantsUrl = url;
        this.restaurantsCategory = category;
    }
}
