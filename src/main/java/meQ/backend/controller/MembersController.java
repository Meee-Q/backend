package meQ.backend.controller;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.dto.members.MembersLoginRequestDto;
import meQ.backend.domain.dto.members.MembersResponseDto;
import meQ.backend.domain.dto.members.MembersSaveRequestDto;
import meQ.backend.service.MembersService;
import meQ.backend.utils.Constant;
import meQ.backend.utils.ResponseApiMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MembersController extends BaseController {
    private final MembersService membersService;

    @PostMapping("/api/v1/members")
    public ResponseEntity<ResponseApiMessage> save(@RequestBody MembersSaveRequestDto requestDto) {
        String membersId = membersService.save(requestDto);

        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "members is saved", membersId);
    }

    @PostMapping("/api/v1/members/login")
    public ResponseEntity<ResponseApiMessage> login(@RequestBody MembersLoginRequestDto requestDto) {
        MembersResponseDto responseDto = membersService.login(requestDto);

        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "login success", responseDto);
    }

    @GetMapping("/api/v1/members/{membersKey}")
    public ResponseEntity<ResponseApiMessage> findByMembersKey(@PathVariable Long membersKey) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "members is loaded", membersService.getMembers(membersKey));
    }

    @GetMapping("/api/v1/members/duplicate/{membersId}")
    public ResponseEntity<ResponseApiMessage> isValidId(@PathVariable String membersId) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "members id duplicate check", membersService.isExistMembersWithMembersId(membersId));
    }
}
