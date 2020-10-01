package com.cabal.challenge.controller;

import com.cabal.challenge.model.CommercePhone;
import com.cabal.challenge.service.CommercePhoneService;
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
public class CommercePhoneController {

    @Autowired
    private CommercePhoneService commercePhoneService;

    @GetMapping("/commercePhones")
    public List<CommercePhone> getPhones() {
        return commercePhoneService.getPhones();
    }

    @PostMapping("/commercePhones")
    public CommercePhone createCommercePhone(@RequestBody CommercePhone commercePhone) {
        return commercePhoneService.savePhone(commercePhone);
    }

    @PutMapping("/commercePhones/{id}")
    public CommercePhone updateCommercePhone(@RequestBody CommercePhone commercePhone,
                                             @PathVariable Long id) {
        return commercePhoneService.updatePhone(commercePhone, id);
    }

    @DeleteMapping("commercePhones/{id}")
    public CommercePhone deleteCommercePhone(@PathVariable Long id) {
        return commercePhoneService.deletePhone(id);
    }

}