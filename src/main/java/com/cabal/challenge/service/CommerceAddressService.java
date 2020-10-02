package com.cabal.challenge.service;

import com.cabal.challenge.model.Commerce;
import com.cabal.challenge.model.CommerceAddress;
import com.cabal.challenge.repository.CommerceAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceAddressService {

    @Autowired
    private CommerceAddressRepository commerceAddressRepository;

    public CommerceAddress saveAddress(CommerceAddress commerceAddress) {
        return commerceAddressRepository.save(commerceAddress);
    }

    public List<CommerceAddress> getAddresses() {
        return commerceAddressRepository.findAll();
    }

    public CommerceAddress getAddressById(Long id) {
        return commerceAddressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found: " + id));
    }

    public CommerceAddress updateAddress(CommerceAddress commerceAddress, Long id) {
        CommerceAddress commerceAddressToUpdate = getAddressById(id);
        commerceAddressToUpdate.setCommerce(new Commerce(commerceAddress.getCommerce().getId()));
        commerceAddressToUpdate.setCep(commerceAddress.getCep());
        commerceAddressToUpdate.setPublicPlace(commerceAddress.getPublicPlace());
        commerceAddressToUpdate.setDistrict(commerceAddress.getDistrict());
        commerceAddressToUpdate.setCity(commerceAddress.getCity());
        commerceAddressToUpdate.setUf(commerceAddress.getUf());
        commerceAddressToUpdate.setAdditionalAddress(commerceAddress.getAdditionalAddress());

        return saveAddress(commerceAddressToUpdate);
    }
}
