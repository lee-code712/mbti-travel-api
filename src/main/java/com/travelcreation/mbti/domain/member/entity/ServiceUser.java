package com.travelcreation.mbti.domain.member.entity;

import com.travelcreation.mbti.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "service_user")
public class ServiceUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ACTIVATION_YN", nullable = false)
    private boolean activationYN;

    @Column(name = "DELETE_YN", nullable = false)
    private boolean deleteYN;

    @Column(name = "USE_PERIOD_START_AT")
    @CreatedDate
    private Timestamp usePeriodStartAt;

    @Column(name = "USE_PERIOD_END_AT")
    private Timestamp usePeriodEndAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ROLE_ID", nullable = false)
    private ServiceUserRole role;

}
