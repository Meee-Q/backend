package meQ.backend.controller;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.dto.membersAllergies.MembersAllergiesSaveRequestDto;
import meQ.backend.service.AllergiesService;
import meQ.backend.service.MembersAllergiesService;
import meQ.backend.utils.Constant;
import meQ.backend.utils.ResponseApiMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MembersAllergiesController extends BaseController {

    private final AllergiesService allergiesService;
    private final MembersAllergiesService membersAllergiesService;

    @PostMapping("/api/v1/setting")
    public ResponseEntity<ResponseApiMessage> setting() {
        allergiesService.setting();
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "setting success", null);
    }

    @PostMapping("/api/v1/members-allergies")
    public ResponseEntity<ResponseApiMessage> save(@RequestBody MembersAllergiesSaveRequestDto requestDto) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "save members allergies information", membersAllergiesService.save(requestDto));
    }

    @PutMapping("/api/v1/members-allergies")
    public ResponseEntity<ResponseApiMessage> update(@RequestBody MembersAllergiesSaveRequestDto requestDto) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "update members allergies information", membersAllergiesService.update(requestDto));
    }

    @GetMapping("/api/v1/members-allergies/{membersKey}")
    public ResponseEntity<ResponseApiMessage> findById(@PathVariable Long membersKey) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "get members allergies information", membersAllergiesService.findById(membersKey));
    }

    @GetMapping("/api/v1/allergies-info/{membersKey}")
    public ResponseEntity<ResponseApiMessage> getMyAllergies(@PathVariable Long membersKey) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "get members allergies information", membersAllergiesService.findById(membersKey));
    }
}
