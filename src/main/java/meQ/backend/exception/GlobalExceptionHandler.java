package meQ.backend.exception;

import lombok.extern.slf4j.Slf4j;
import meQ.backend.controller.BaseController;
import meQ.backend.utils.ResponseApiMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.charset.StandardCharsets;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({LoginFailException.class})
    public ResponseEntity<ResponseApiMessage> handleLoginFailException(LoginFailException exception) {
        ResponseApiMessage responseApiMessage = ResponseApiMessage.builder()
                .httpStatus(400)
                .message("id or password is not valid")
                .responseData(400)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", StandardCharsets.UTF_8));

        log.warn("id or password is not valid");

        return new ResponseEntity<>(responseApiMessage, headers, 400);
    }
}
