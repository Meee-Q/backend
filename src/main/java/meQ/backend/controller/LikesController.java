package meQ.backend.controller;

import lombok.RequiredArgsConstructor;
import meQ.backend.domain.dto.likes.LikesSaveRequestDto;
import meQ.backend.service.LikesService;
import meQ.backend.service.MenusService;
import meQ.backend.utils.Constant;
import meQ.backend.utils.ResponseApiMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LikesController extends BaseController{

    private final LikesService likesService;

    @PostMapping("/api/v1/likes")
    public ResponseEntity<ResponseApiMessage> like(@RequestBody LikesSaveRequestDto requestDto) {
        likesService.like(requestDto);
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "like saved", null);
    }

    @DeleteMapping("/api/v1/likes")
    public ResponseEntity<ResponseApiMessage> unlike(@RequestBody LikesSaveRequestDto requestDto) {
        likesService.unlike(requestDto);
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "like deleted", null);
    }

    @GetMapping("/api/v1/likes/{membersKey}")
    public ResponseEntity<ResponseApiMessage> getLikes(@PathVariable Long membersKey) {
        return sendResponseHttpByJson(Constant.SUCCESS_CODE, "likes load with membersKey = " + membersKey, likesService.getLikes(membersKey));
    }
}
