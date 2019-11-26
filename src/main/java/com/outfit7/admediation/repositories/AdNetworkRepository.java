package com.outfit7.admediation.repositories;

import com.outfit7.admediation.model.entity.AdNetworkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Ivana Kostadinovska on 25-Nov-19.
 */
public interface AdNetworkRepository extends JpaRepository<AdNetworkEntity, Long> {

    List<AdNetworkEntity> findByOrderByPerformanceAsc();
    List<AdNetworkEntity> findByOrderByPerformanceDesc();
}
