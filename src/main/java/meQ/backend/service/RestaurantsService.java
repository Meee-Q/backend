package meQ.backend.service;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.entity.Restaurants;
import meQ.backend.repository.RestaurantsRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.Reader;

@RequiredArgsConstructor
@Service
public class RestaurantsService {

    private final RestaurantsRepository restaurantsRepository;

    public void saveRestaurants() throws Exception {
        JSONParser parser = new JSONParser();

        // JSON 파일 읽기
        Reader reader = new FileReader("/Users/j2n2/Desktop/Programming/MeQ/restaurants.json");
        JSONArray dateArray = (JSONArray) parser.parse(reader);

        for (Object place : dateArray) {
            JSONObject element = (JSONObject) place;

            String placeName = (String) element.get("place_name");
            String placeAddress = (String) element.get("road_address_name");
            String categoryName = getCategoryName((String) element.get("category_name"));
            String number = (String) element.get("phone");
            String placeUrl = (String) element.get("place_url");
            String longitude = (String) element.get("x");
            String latitude = (String) element.get("y");

            restaurantsRepository.save(Restaurants.createRestaurants(placeName, placeAddress, longitude, latitude, number, placeUrl, categoryName));
        }
    }

    private String getCategoryName(String category) {
        String[] list = category.split(" ");
        return list[2];
    }
}
