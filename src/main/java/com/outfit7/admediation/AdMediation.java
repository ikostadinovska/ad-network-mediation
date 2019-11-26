package com.outfit7.admediation;

import com.outfit7.admediation.model.entity.AdNetworkEntity;
import com.outfit7.admediation.repositories.AdNetworkRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Ivana Kostadinovska on 25-Nov-19.
 */

@SpringBootApplication
public class AdMediation {
    public static void main(String [] args){
        SpringApplication.run(AdMediation.class, args);
    }

    @Bean
    public CommandLineRunner demo(AdNetworkRepository repository){
        return (args) -> {

            AdNetworkEntity adNetworkEntity = new AdNetworkEntity();
            adNetworkEntity.setName("AdMob");
            adNetworkEntity.setUuid("147878778");
            adNetworkEntity.setPerformance(87);
            repository.save(adNetworkEntity);

            adNetworkEntity = new AdNetworkEntity();
            adNetworkEntity.setName("Adx");
            adNetworkEntity.setUuid("1475543778");
            adNetworkEntity.setPerformance(97);
            repository.save(adNetworkEntity);

            adNetworkEntity = new AdNetworkEntity();
            adNetworkEntity.setName("Unity Ads");
            adNetworkEntity.setUuid("13412178778");
            adNetworkEntity.setPerformance(41);
            repository.save(adNetworkEntity);
        };
    }
}
