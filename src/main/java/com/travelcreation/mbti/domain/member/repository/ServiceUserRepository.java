package com.travelcreation.mbti.domain.member.repository;

import com.travelcreation.mbti.domain.member.entity.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceUserRepository extends JpaRepository<ServiceUser, Long> {
}
