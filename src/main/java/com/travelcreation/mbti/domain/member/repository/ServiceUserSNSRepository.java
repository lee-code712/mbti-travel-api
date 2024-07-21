package com.travelcreation.mbti.domain.member.repository;

import com.travelcreation.mbti.domain.member.entity.ServiceUserSNS;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceUserSNSRepository extends JpaRepository<ServiceUserSNS, Long> {

    Optional<ServiceUserSNS> findByUserEmailAndPlatform(String email, ServiceUserSNS.PLATFORM platform);

}
