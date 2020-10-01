package com.cabal.challenge.controller;

import com.cabal.challenge.model.Commerce;
import com.cabal.challenge.service.CommerceService;
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
public class CommerceController {

    @Autowired
    private CommerceService commerceService;

    public CommerceController(CommerceService commerceService) {
        this.commerceService = commerceService;
    }

    @GetMapping("/commerces")
    public List<Commerce> getCommerces() {
        return commerceService.getCommerces();
    }

    @GetMapping("/commerces/{id}")
    public Commerce getCommerceById(@PathVariable Long id) {
        return commerceService.getCommerceById(id);
    }

    @PostMapping("/commerces")
    public Commerce createCommerce(@RequestBody Commerce commerce) {
        return commerceService.saveCommerce(commerce);
    }

    @PutMapping("/commerces/{id}")
    public Commerce updateCommerce(@RequestBody Commerce commerce, @PathVariable Long id) {
        return commerceService.updateCommerce(commerce, id);
    }

    @DeleteMapping("commerces/{id}")
    public Commerce deleteCommerce(@PathVariable Long id) {
        return commerceService.deleteCommerce(id);
    }

}
