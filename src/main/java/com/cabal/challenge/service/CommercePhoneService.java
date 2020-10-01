package com.cabal.challenge.service;

import com.cabal.challenge.model.Commerce;
import com.cabal.challenge.model.CommercePhone;
import com.cabal.challenge.repository.CommercePhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommercePhoneService {

    @Autowired
    private CommercePhoneRepository commercePhoneRepository;

    public CommercePhone savePhone(CommercePhone commercePhone) {
        return commercePhoneRepository.save(commercePhone);
    }

    public List<CommercePhone> getPhones() {
        return commercePhoneRepository.findAll();
    }

    public CommercePhone getPhoneById(Long id) {
        return commercePhoneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Phone not found: " + id));
    }

    public CommercePhone deletePhone(Long id) {
        CommercePhone commercePhoneToDelete = getPhoneById(id);
        commercePhoneRepository.delete(commercePhoneToDelete);

        return commercePhoneToDelete;
    }

    public CommercePhone updatePhone(CommercePhone commercePhone, Long id) {
        CommercePhone commercePhoneToUpdate = getPhoneById(id);
        commercePhoneToUpdate.setCommerce(new Commerce(commercePhone.getCommerce().getId()));
        commercePhoneToUpdate.setNumber(commercePhone.getNumber());
        commercePhoneToUpdate.setTypeNumber(commercePhone.getTypeNumber());

        return savePhone(commercePhoneToUpdate);
    }
}
