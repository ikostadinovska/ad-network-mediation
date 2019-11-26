package com.outfit7.admediation.rest.impl;

import com.outfit7.admediation.bean.AdNetworkBean;
import com.outfit7.admediation.model.dto.AdNetwork;
import com.outfit7.admediation.rest.AdNetworksService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


/**
 * Created by Ivana Kostadinovska on 25-Nov-19.
 */
@Api(tags = {"Ad-Mediation Service"})
@RestController
public class AdNetworksImpl implements AdNetworksService {


    @Autowired
    private AdNetworkBean adNetworkBean;

    @Override
    public ResponseEntity add(@RequestBody AdNetwork adNetwork) {


        return ResponseEntity.ok(adNetworkBean.addAdNetwork(adNetwork));
    }

    @Override
    public ResponseEntity<List<AdNetwork>> findAll() {
        return ResponseEntity.ok(adNetworkBean.findAll());
    }

    @Override
    public ResponseEntity delete(@PathVariable Long id) {
        boolean deleted = adNetworkBean.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<AdNetwork> update(@Valid @RequestBody AdNetwork adNetworkDTOIn,
                                            @PathVariable Long id) {
        return Optional
                .ofNullable(adNetworkBean.update(id, adNetworkDTOIn))
                .map(network -> ResponseEntity.ok().body(network))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<AdNetwork>> update(@Valid List<AdNetwork> adNetworkList) {
        return ResponseEntity.ok(adNetworkBean.updateAdNetworkList(adNetworkList));
    }
}

