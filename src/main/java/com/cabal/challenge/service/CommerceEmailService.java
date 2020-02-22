package com.cabal.challenge.service;

import com.cabal.challenge.model.Commerce;
import com.cabal.challenge.model.CommerceEmail;
import com.cabal.challenge.repository.CommerceEmailRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommerceEmailService {

    private final CommerceEmailRepository CommerceEmailRepository;

    public CommerceEmailService(CommerceEmailRepository CommerceEmailRepository) {
        this.CommerceEmailRepository = CommerceEmailRepository;
    }

    public CommerceEmail saveEmail(CommerceEmail CommerceEmail) {
        return CommerceEmailRepository.save(CommerceEmail);
    }

    public List<CommerceEmail> getEmails() {
        return CommerceEmailRepository.findAll();
    }

    public CommerceEmail getEmailById(Long id) {
        return CommerceEmailRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Email not found: " + id));
    }

    public CommerceEmail deleteEmail(Long id) {
        CommerceEmail CommerceEmailToDelete = getEmailById(id);
        CommerceEmailRepository.delete(CommerceEmailToDelete);

        return CommerceEmailToDelete;
    }

    public CommerceEmail updateEmail(CommerceEmail CommerceEmail, Long id) {
        CommerceEmail CommerceEmailToUpdate = getEmailById(id);
        CommerceEmailToUpdate.setCommerce(new Commerce(CommerceEmail.getCommerce().getId()));
        CommerceEmailToUpdate.setEmail(CommerceEmail.getEmail());

        return saveEmail(CommerceEmailToUpdate);
    }
}