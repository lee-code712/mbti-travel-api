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
@Table(name = "service_user_role")
public class ServiceUserRole extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ROLE_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE_NAME", nullable = false)
    private Role roleName;

    public enum Role {
        ROLE_ADMIN, ROLE_USER
    }

}
