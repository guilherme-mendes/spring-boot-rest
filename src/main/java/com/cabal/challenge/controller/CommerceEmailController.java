package com.cabal.challenge.controller;

import com.cabal.challenge.model.CommerceEmail;
import com.cabal.challenge.service.CommerceEmailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CommerceEmailController {

    private final CommerceEmailService commerceEmailService;

    public CommerceEmailController(CommerceEmailService commerceEmailService) {
        this.commerceEmailService = commerceEmailService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/commerceEmails")
    public List<CommerceEmail> getEmails() {
        return commerceEmailService.getEmails();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/commercesEmails")
    public CommerceEmail createEmail(@RequestBody CommerceEmail commerceEmail) {
        return commerceEmailService.saveEmail(commerceEmail);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/commercesEmails/{id}")
    public CommerceEmail updateEmail(@RequestBody CommerceEmail commerceEmail, @PathVariable Long id) {
        return commerceEmailService.updateEmail(commerceEmail, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "commercesEmails/{id}")
    public CommerceEmail deleteEmail(@PathVariable Long id) {
        return commerceEmailService.deleteEmail(id);
    }

}

