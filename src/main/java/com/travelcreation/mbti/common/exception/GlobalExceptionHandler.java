package com.travelcreation.mbti.common.exception;

import com.travelcreation.mbti.common.model.response.BaseResponse;
import com.travelcreation.mbti.domain.member.exception.PasswordMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 전역 예외 처리 클래스
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 비밀번호 확인 값 일치 여부에 대한 예외 처리
     * @param e PasswordMismatchException 객체
     * @return  ResponseEntity 객체
     */
    @ExceptionHandler(PasswordMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BaseResponse<String>> handlePasswordMismatchException(PasswordMismatchException e) {
        return BaseResponse.of(HttpStatus.BAD_REQUEST, e.getMessage());
    }

}
