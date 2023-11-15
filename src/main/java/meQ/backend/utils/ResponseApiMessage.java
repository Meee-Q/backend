package meQ.backend.utils;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ResponseApiMessage {
    int httpStatus;
    String message;
    Object responseData;

    @Builder
    public ResponseApiMessage(int httpStatus, String message, Object responseData){
        this.httpStatus = httpStatus;
        this.message = message;
        this.responseData = responseData;
    }
}
