package com.cabal.challenge.service;

import com.cabal.challenge.model.Commerce;
import com.cabal.challenge.model.CommerceEmail;
import com.cabal.challenge.repository.CommerceEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceEmailService {

    @Autowired
    private CommerceEmailRepository commerceEmailRepository;

    public CommerceEmail saveEmail(CommerceEmail commerceEmail) {
        return commerceEmailRepository.save(commerceEmail);
    }

    public List<CommerceEmail> getEmails() {
        return commerceEmailRepository.findAll();
    }

    public CommerceEmail getEmailById(Long id) {
        return commerceEmailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Email not found: " + id));
    }

    public CommerceEmail deleteEmail(Long id) {
        CommerceEmail commerceEmailToDelete = getEmailById(id);
        commerceEmailRepository.delete(commerceEmailToDelete);

        return commerceEmailToDelete;
    }

    public CommerceEmail updateEmail(CommerceEmail commerceEmail, Long id) {
        CommerceEmail commerceEmailToUpdate = getEmailById(id);
        commerceEmailToUpdate.setCommerce(new Commerce(commerceEmail.getCommerce().getId()));
        commerceEmailToUpdate.setEmail(commerceEmail.getEmail());

        return saveEmail(commerceEmailToUpdate);
    }
}