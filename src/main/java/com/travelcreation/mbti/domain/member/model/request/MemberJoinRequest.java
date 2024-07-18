package com.travelcreation.mbti.domain.member.model.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "회원가입 정보")
public class MemberJoinRequest {
}
