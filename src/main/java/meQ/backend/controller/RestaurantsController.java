package meQ.backend.controller;

import lombok.RequiredArgsConstructor;
import meQ.backend.service.RestaurantsService;
import meQ.backend.utils.Constant;
import meQ.backend.utils.ResponseApiMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RestaurantsController extends BaseController {

    private final RestaurantsService restaurantsService;

    @GetMapping("/api/v1/restaurants-setting")
    public ResponseEntity<ResponseApiMessage> test() throws Exception {
        restaurantsService.saveRestaurants();
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "restaurants setting succeed", null);
    }
}
