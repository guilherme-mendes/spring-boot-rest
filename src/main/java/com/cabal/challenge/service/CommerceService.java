package com.cabal.challenge.service;

import com.cabal.challenge.model.Commerce;
import com.cabal.challenge.repository.CommerceRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceService {

    private final CommerceRepository commerceRepository;

    public CommerceService(CommerceRepository commerceRepository) {
        this.commerceRepository = commerceRepository;
    }

    public Commerce saveCommerce(Commerce commerce) {
        return commerceRepository.save(commerce);
    }

    public List<Commerce> getCommerces() {
        return commerceRepository.findAll();
    }

    public Commerce getCommerceById(Long id) {
        return commerceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Commerce not found: " + id));
    }

    public Commerce deleteCommerce(Long id) {
        Commerce commerceToDelete = getCommerceById(id);
        commerceRepository.delete(commerceToDelete);

        return commerceToDelete;
    }

    public Commerce updateCommerce(Commerce commerce, Long id) {
        Commerce commerceToUpdate = getCommerceById(id);
        commerceToUpdate.setName(commerce.getName());
        commerceToUpdate.setCnpj(commerce.getCnpj());

        return saveCommerce(commerceToUpdate);
    }

}
