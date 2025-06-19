package com.onaonline.lami.lami_backend.data.repos;

import com.onaonline.lami.lami_backend.data.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
}
