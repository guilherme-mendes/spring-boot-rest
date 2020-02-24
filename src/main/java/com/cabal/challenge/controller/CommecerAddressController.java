package com.cabal.challenge.controller;

import com.cabal.challenge.model.CommerceAddress;
import com.cabal.challenge.service.CommerceAddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class CommecerAddressController {

    private final CommerceAddressService commerceAddressService;

    public CommecerAddressController(CommerceAddressService commerceAddressService) {
        this.commerceAddressService = commerceAddressService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/commerceAddress")
    public List<CommerceAddress> getAddress() {
        return commerceAddressService.getAddresses();
    }

    @RequestMapping(method = RequestMethod.POST, path = "commerceAddress")
    public CommerceAddress createAddress(@RequestBody CommerceAddress commerceAddress) {
        return commerceAddressService.saveAddress(commerceAddress);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/commerceAddress/{id}")
    public CommerceAddress updateAddress(@RequestBody CommerceAddress commerceAddress,
                                         @PathVariable Long id) {
        return commerceAddressService.updateAddress(commerceAddress, id);
    }

}
