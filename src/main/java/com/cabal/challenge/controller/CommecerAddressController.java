package com.cabal.challenge.controller;

import com.cabal.challenge.model.CommerceAddress;
import com.cabal.challenge.service.CommerceAddressService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CommecerAddressController {

    @Autowired
    private CommerceAddressService commerceAddressService;

    public CommecerAddressController(CommerceAddressService commerceAddressService) {
        this.commerceAddressService = commerceAddressService;
    }

    @GetMapping("/commerceAddress")
    public List<CommerceAddress> getAddress() {
        return commerceAddressService.getAddresses();
    }

    @PostMapping("commerceAddress")
    public CommerceAddress createAddress(@RequestBody CommerceAddress commerceAddress) {
        return commerceAddressService.saveAddress(commerceAddress);
    }

    @PutMapping("/commerceAddress/{id}")
    public CommerceAddress updateAddress(@RequestBody CommerceAddress commerceAddress,
                                         @PathVariable Long id) {
        return commerceAddressService.updateAddress(commerceAddress, id);
    }

}
