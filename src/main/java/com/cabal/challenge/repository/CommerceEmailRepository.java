package com.cabal.challenge.repository;

import com.cabal.challenge.model.CommerceEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommerceEmailRepository extends JpaRepository<CommerceEmail, Long> {
}
