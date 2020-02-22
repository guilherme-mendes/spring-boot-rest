package com.cabal.challenge.service;

import com.cabal.challenge.model.Commerce;
import com.cabal.challenge.model.CommerceAddress;
import com.cabal.challenge.repository.CommerceAddressRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceAddressService {

    private final CommerceAddressRepository CommerceAddressRepository;

    public CommerceAddressService(CommerceAddressRepository CommerceAddressRepository) {
        this.CommerceAddressRepository = CommerceAddressRepository;
    }

    public CommerceAddress saveAddress(CommerceAddress CommerceAddress) {
        return CommerceAddressRepository.save(CommerceAddress);
    }

    public List<CommerceAddress> getAddresses() {
        return CommerceAddressRepository.findAll();
    }

    public CommerceAddress getAddressById(Long id) {
        return CommerceAddressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found: " + id));
    }

    public CommerceAddress updateAddress(CommerceAddress CommerceAddress, Long id) {
        CommerceAddress CommerceAddressToUpdate = getAddressById(id);
        CommerceAddressToUpdate.setCommerce(new Commerce(CommerceAddress.getCommerce().getId()));
        CommerceAddressToUpdate.setCep(CommerceAddress.getCep());
        CommerceAddressToUpdate.setPublicPlace(CommerceAddress.getPublicPlace());
        CommerceAddressToUpdate.setDistrict(CommerceAddress.getDistrict());
        CommerceAddressToUpdate.setCity(CommerceAddress.getCity());
        CommerceAddressToUpdate.setUf(CommerceAddress.getUf());
        CommerceAddressToUpdate.setAdditionalAddress(CommerceAddress.getAdditionalAddress());

        return saveAddress(CommerceAddressToUpdate);
    }
}
