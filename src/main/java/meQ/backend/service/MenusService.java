package meQ.backend.service;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.entity.Allergies;
import meQ.backend.domain.entity.Menus;
import meQ.backend.domain.entity.MenusAllergies;
import meQ.backend.domain.entity.Restaurants;
import meQ.backend.repository.AllergiesRepository;
import meQ.backend.repository.MenusAllergiesRepository;
import meQ.backend.repository.MenusRepository;
import meQ.backend.repository.RestaurantsRepository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.Reader;

@RequiredArgsConstructor
@Service
public class MenusService {

    private final MenusRepository menusRepository;
    private final RestaurantsRepository restaurantsRepository;
    private final AllergiesRepository allergiesRepository;
    private final MenusAllergiesRepository menusAllergiesRepository;

    private Restaurants findRestaurants(Long restaurantsId) {
        return restaurantsRepository.findById(restaurantsId)
                .orElseThrow(() -> new IllegalArgumentException("there is no [" + restaurantsId + "] restaurants"));
    }

    private Allergies findAllergies(Long allergiesId) {
        return allergiesRepository.findById(allergiesId)
                .orElseThrow(() -> new IllegalArgumentException("there is no [" + allergiesId + "] allergies"));
    }

    public void saveMenus() throws Exception {
        JSONParser parser = new JSONParser();

        // JSON 파일 읽기
        Reader reader = new FileReader("/Users/j2n2/Desktop/Programming/MeQ/menus.json");
        JSONArray dateArray = (JSONArray) parser.parse(reader);

        for (Object place : dateArray) {
            JSONObject element = (JSONObject) place;

            Long restaurantsId = (Long) element.get("restaurantsId");
            JSONArray menusArray = (JSONArray) element.get("menus");

            // 식당 찾기
            Restaurants restaurants = findRestaurants(restaurantsId);

            for (Object menus : menusArray){
                JSONObject eachMenu = (JSONObject) menus;

                String menusName = (String) eachMenu.get("menus_name");
                JSONArray allergiesArray = (JSONArray) eachMenu.get("allergies");

                // 메뉴 저장
                Menus newMenus = Menus.createMenus(menusName, restaurants);
                menusRepository.save(newMenus);


                for (Object allergiesNum : allergiesArray) {
                    Long allergiesId = (Long) allergiesNum;

                    // 알러지 찾기
                    Allergies allergies = findAllergies(allergiesId);

                    // 메뉴당 알러지 정보 저장
                    MenusAllergies menusAllergies = MenusAllergies.createMenusAllergies(newMenus, allergies);
                    menusAllergiesRepository.save(menusAllergies);
                }
            }
        }
    }
}
