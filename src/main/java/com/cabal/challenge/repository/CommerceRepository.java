package com.cabal.challenge.repository;

import com.cabal.challenge.model.Commerce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommerceRepository extends JpaRepository<Commerce, Long> {
}
