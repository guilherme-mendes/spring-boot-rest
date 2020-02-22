package com.cabal.challenge.controller;

import com.cabal.challenge.model.Commerce;
import com.cabal.challenge.service.CommerceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CommerceController {

    private final CommerceService commerceService;

    public CommerceController(CommerceService commerceService) {
        this.commerceService = commerceService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/commerces")
    public List<Commerce> getCommerces() {
        return commerceService.getCommerces();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/commerces/{id}")
    public Commerce getCommerceById(@PathVariable Long id) {
        return commerceService.getCommerceById(id);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/commerces")
    public Commerce createCommerce(@RequestBody Commerce commerce) {
        return commerceService.saveCommerce(commerce);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/commerces/{id}")
    public Commerce updateCommerce(@RequestBody Commerce commerce, @PathVariable Long id) {
        return commerceService.updateCommerce(commerce, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "commerces/{id}")
    public Commerce deleteCommerce(@PathVariable Long id) {
        return commerceService.deleteCommerce(id);
    }

}
