package com.travelcreation.mbti.common.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Builder
@Schema(description = "기본 응답")
public class BaseResponse<T> {

    @Schema(description = "상태 코드")
    private String code;

    @Schema(description = "메시지")
    private T message;

    public static <T> ResponseEntity<BaseResponse<T>> of(HttpStatus status, T message) {
        return ResponseEntity
                .status(status)
                .body(BaseResponse.<T>builder()
                        .code(status.name())
                        .message(message)
                        .build());
    }

}
