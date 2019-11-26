package com.outfit7.admediation.rest;

import com.outfit7.admediation.model.dto.AdNetwork;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Ivana Kostadinovska on 26-Nov-19.
 */
public interface AdNetworksService {

    @ApiOperation(value = "Add new ad-network.", notes = "Method adds new ad-network into the database.")
    @PostMapping(value = "/v1/ad-networks")
    ResponseEntity add(@RequestBody AdNetwork adNetwork);


    @GetMapping(value = "/v1/ad-networks")
    ResponseEntity<List<AdNetwork>> findAll();


    @DeleteMapping(value = "/v1/ad-networks/{id}")
    ResponseEntity delete(@PathVariable Long id);

    @PutMapping(value = "/v1/ad-networks/{id}")
    ResponseEntity<AdNetwork> update(@Valid @RequestBody AdNetwork adNetwork,
                                           @PathVariable Long id);

    @PutMapping(value = "/v1/ad-networks")
    ResponseEntity<List<AdNetwork>> update(@Valid @RequestBody List<AdNetwork> adNetworkList);
}
