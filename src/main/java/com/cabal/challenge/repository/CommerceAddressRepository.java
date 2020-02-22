package com.cabal.challenge.repository;

import com.cabal.challenge.model.CommerceAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommerceAddressRepository extends JpaRepository<CommerceAddress, Long> {
}
