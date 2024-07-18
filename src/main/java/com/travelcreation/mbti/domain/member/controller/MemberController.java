package com.travelcreation.mbti.domain.member.controller;

import com.travelcreation.mbti.common.model.response.BaseResponse;
import com.travelcreation.mbti.domain.member.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "member", description = "회원 API")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/members")
public class MemberController {

    private final MemberService memberSvc;

    @Operation(summary = "요청 테스트")
    @GetMapping(path = "/health")
    public ResponseEntity<BaseResponse<String>> healthCheck() {
        return BaseResponse.of(HttpStatus.OK, "성공");
    }

}
