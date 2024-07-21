package com.travelcreation.mbti.domain.member.entity;

import com.travelcreation.mbti.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "service_user_sns")
public class ServiceUserSNS extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SNS_USER_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private ServiceUser user;

    @Column(name = "ACCESS_TOKEN", nullable = false)
    private String accessToken;

    @Enumerated(EnumType.STRING)
    @Column(name = "PLATFORM", nullable = false)
    private PLATFORM platform;

    public enum PLATFORM {
        KAKAO
    }

}
