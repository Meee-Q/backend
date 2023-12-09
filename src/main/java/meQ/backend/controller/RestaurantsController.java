package meQ.backend.controller;

import lombok.RequiredArgsConstructor;
import meQ.backend.service.RestaurantsService;
import meQ.backend.utils.Constant;
import meQ.backend.utils.ResponseApiMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestaurantsController extends BaseController {

    private final RestaurantsService restaurantsService;

    @PostMapping("/api/v1/restaurants-setting")
    public ResponseEntity<ResponseApiMessage> saveRestaurants() throws Exception {
        restaurantsService.saveRestaurants();
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "restaurants setting succeed", null);
    }

    @GetMapping("/api/v1/restaurants/{membersKey}")
    public ResponseEntity<ResponseApiMessage> getRestaurants(@PathVariable Long membersKey) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "restaurants load with membersKey = " + membersKey, restaurantsService.getRestaurants(membersKey));
    }
}
