package com.outfit7.admediation.bean;

import com.outfit7.admediation.model.dto.AdNetwork;
import com.outfit7.admediation.model.entity.AdNetworkEntity;
import com.outfit7.admediation.repositories.AdNetworkRepository;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ivana Kostadinovska on 26-Nov-19.
 */
@Component
public class AdNetworkBean {

    @Autowired
    private AdNetworkRepository adNetworkRepository;

    public AdNetwork addAdNetwork(AdNetwork adNetwork) {
        AdNetworkEntity adNetworkEntity = new AdNetworkEntity();
        adNetworkEntity.setName(adNetwork.getName());
        adNetworkEntity.setPerformance(adNetwork.getPerformance());
        adNetworkEntity.setUuid(adNetwork.getUuid());
        adNetworkRepository.save(adNetworkEntity);

        adNetwork.setId(adNetworkEntity.getId());
        return adNetwork;
    }

    public List<AdNetwork> findAll() {
        List<AdNetworkEntity> adNetworkEntityList = adNetworkRepository.findByOrderByPerformanceDesc();
        return adNetworkEntityList.stream().map(AdNetwork::new).collect(Collectors.toList());
    }

    public boolean delete(Long id) {
        AdNetworkEntity adNetworkEntity = adNetworkRepository.getOne(id);
        if (adNetworkEntity != null) {
            adNetworkRepository.delete(adNetworkEntity);
            return true;
        }
        return false;
    }

    public AdNetwork update(Long id, AdNetwork adNetworkDto) {
        try {
            AdNetworkEntity adNetworkEntity = adNetworkRepository.getOne(id);
            adNetworkEntity.setId(id);
            adNetworkEntity.setName(adNetworkDto.getName());
            adNetworkEntity.setPerformance(adNetworkDto.getPerformance());
            adNetworkRepository.save(adNetworkEntity);

            return new AdNetwork(adNetworkEntity);
        } catch (EntityNotFoundException e) {
            Logger.getLogger(AdNetworkBean.class.getName()).error("Entity not found for id: " + id);
        }
        return null;
    }

    public List<AdNetwork> updateAdNetworkList(@Valid List<AdNetwork> adNetworkList) {
        return adNetworkList.stream().map(network -> update(network.getId(), network)).collect(Collectors.toList());
    }
}
