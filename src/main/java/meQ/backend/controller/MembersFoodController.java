package meQ.backend.controller;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.dto.membersFoods.MembersFoodsSaveRequestDto;
import meQ.backend.service.FoodsService;
import meQ.backend.service.MembersFoodsService;
import meQ.backend.utils.Constant;
import meQ.backend.utils.ResponseApiMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MembersFoodController extends BaseController{

    private final FoodsService foodsService;
    private final MembersFoodsService membersFoodsService;

    @PostMapping("/api/v1/foods-setting")
    public ResponseEntity<ResponseApiMessage> setting() {
        foodsService.setting();
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "foods setting succeed", null);
    }

    @PostMapping("/api/v1/members-foods")
    public ResponseEntity<ResponseApiMessage> save(@RequestBody MembersFoodsSaveRequestDto requestDto) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "save members foods information", membersFoodsService.save(requestDto));
    }

    @GetMapping("/api/v1/members-foods/{membersKey}")
    public ResponseEntity<ResponseApiMessage> findById(@PathVariable Long membersKey) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "get members foods information", membersFoodsService.findById(membersKey));
    }

    @PutMapping("/api/v1/members-foods")
    public ResponseEntity<ResponseApiMessage> update(@RequestBody MembersFoodsSaveRequestDto requestDto) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "update members foods information", membersFoodsService.update(requestDto));
    }

    @GetMapping("/api/v1/foods-info/{membersKey}")
    public ResponseEntity<ResponseApiMessage> getMyFoods(@PathVariable Long membersKey) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "get members foods information", membersFoodsService.findById(membersKey));
    }
}
