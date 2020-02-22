package com.cabal.challenge.controller;

import com.cabal.challenge.model.CommercePhone;
import com.cabal.challenge.service.CommercePhoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CommercePhoneController {

    private final CommercePhoneService commercePhoneService;

    public CommercePhoneController(CommercePhoneService commercePhoneService) {
        this.commercePhoneService = commercePhoneService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/commercePhones")
    public List<CommercePhone> getPhones() {
        return commercePhoneService.getPhones();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/commercePhones")
    public CommercePhone createCommercePhone(@RequestBody CommercePhone commercePhone) {
        return commercePhoneService.savePhone(commercePhone);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/commercePhones/{id}")
    public CommercePhone updateCommercePhone(@RequestBody CommercePhone commercePhone,
                                             @PathVariable Long id) {
        return commercePhoneService.updatePhone(commercePhone, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "commercePhones/{id}")
    public CommercePhone deleteCommercePhone(@PathVariable Long id) {
        return commercePhoneService.deletePhone(id);
    }

}