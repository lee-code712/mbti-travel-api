package com.travelcreation.mbti.domain.member.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(description = "회원 상세 정보")
public class MemberDetailResponse {
}
