package com.onaonline.lami.lami_backend.data.repos;

import com.onaonline.lami.lami_backend.data.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetails, Long> {
    Optional<UserDetails> findByEmail(String email);
    Optional<UserDetails> findByPassword(String password);

}
