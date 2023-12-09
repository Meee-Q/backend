package meQ.backend.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import meQ.backend.service.MenusService;
import meQ.backend.utils.Constant;
import meQ.backend.utils.ResponseApiMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MenusController extends BaseController{

    private final MenusService menusService;

    @PostMapping("/api/v1/menus-setting")
    public ResponseEntity<ResponseApiMessage> setting() throws Exception {
        menusService.saveMenus();
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "menus setting succeed", null);
    }
}
