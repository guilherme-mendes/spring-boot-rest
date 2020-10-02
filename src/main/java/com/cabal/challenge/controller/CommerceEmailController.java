package com.cabal.challenge.controller;

import com.cabal.challenge.model.CommerceEmail;
import com.cabal.challenge.service.CommerceEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CommerceEmailController {

    @Autowired
    private CommerceEmailService commerceEmailService;

    public CommerceEmailController(CommerceEmailService commerceEmailService) {
        this.commerceEmailService = commerceEmailService;
    }

    @GetMapping("/commerceEmails")
    public List<CommerceEmail> getEmails() {
        return commerceEmailService.getEmails();
    }

    @PostMapping("/commercesEmails")
    public CommerceEmail createEmail(@RequestBody CommerceEmail commerceEmail) {
        return commerceEmailService.saveEmail(commerceEmail);
    }

    @PutMapping("/commercesEmails/{id}")
    public CommerceEmail updateEmail(@RequestBody CommerceEmail commerceEmail, @PathVariable Long id) {
        return commerceEmailService.updateEmail(commerceEmail, id);
    }

    @DeleteMapping("commercesEmails/{id}")
    public CommerceEmail deleteEmail(@PathVariable Long id) {
        return commerceEmailService.deleteEmail(id);
    }

}

