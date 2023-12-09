package meQ.backend.service;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.dto.restaurants.MembersRestaurantsResponseDto;
import meQ.backend.domain.dto.restaurants.RestaurantsResponseDto;
import meQ.backend.domain.entity.*;
import meQ.backend.repository.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantsService {

    private final RestaurantsRepository restaurantsRepository;
    private final MembersRepository membersRepository;


    private Members findMembers(Long membersKey) {
        return membersRepository.findById(membersKey)
                .orElseThrow(() -> new IllegalArgumentException("there is no [" + membersKey + "] members"));
    }

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

    // 해당하는 사용자가 등록한 알레르기 정보 제외한 식당만 리턴
    public MembersRestaurantsResponseDto getRestaurants(Long membersKey) {
        List<RestaurantsResponseDto> restaurantsResponseDtoList = new ArrayList<>();

        // 사용자와 사용자가 보유한 알러지 확보
        Members members = findMembers(membersKey);
        List<MembersAllergies> membersAllergiesList = members.getAllergies();

        List<Restaurants> restaurants = restaurantsRepository.findAll();

        // 모든 식당의 메뉴 확인하며 알러지 정보 확인
        for (Restaurants eachRestaurants : restaurants) {
            boolean isSafe = true;

            List<Menus> menus = eachRestaurants.getMenus();

            // 각 메뉴당 알러지 정보 확인
            for (Menus eachMenus : menus) {
                List<Long> allergiesWithMenus = getAllergiesWithMenus(eachMenus.getMenusAllergies());
                List<Long> allergiesWithMembers = getAllergiesWithMembers(membersAllergiesList);

                // 사용자가 가지고 있는 알레르기 정보와 메뉴가 가지고 있는 알레르기 정보 비교
                allergiesWithMembers.retainAll(allergiesWithMenus);

                // 만약 리스트의 크기가 1 이상이라면 알레르기 유발 위험
                if (allergiesWithMembers.size() > 0) {
                    isSafe = false;
                    break;
                }
            }

            // 해당 식당이 안전하다면 리스트에 저장
            if (isSafe) {
                restaurantsResponseDtoList.add(new RestaurantsResponseDto(
                        eachRestaurants.getRestaurantsId(),
                        eachRestaurants.getRestaurantsName(),
                        eachRestaurants.getNumber(),
                        eachRestaurants.getAddress(),
                        eachRestaurants.getLongitude(),
                        eachRestaurants.getLatitude(),
                        eachRestaurants.getUrl(),
                        eachRestaurants.getCategory()
                ));
            }
        }

        return new MembersRestaurantsResponseDto(membersKey, restaurantsResponseDtoList);
    }

    private List<Long> getAllergiesWithMembers(List<MembersAllergies> membersAllergies) {
        List<Long> allergies = new ArrayList<>();

        for (MembersAllergies each : membersAllergies) {
            allergies.add(each.getAllergies().getAllergiesId());
        }

        return allergies;
    }

    private List<Long> getAllergiesWithMenus(List<MenusAllergies> menusAllergies) {
        List<Long> allergies = new ArrayList<>();

        for (MenusAllergies each : menusAllergies) {
            allergies.add(each.getAllergies().getAllergiesId());
        }

        return allergies;
    }

}
