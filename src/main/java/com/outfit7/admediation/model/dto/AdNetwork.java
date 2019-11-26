package com.outfit7.admediation.model.dto;

import com.outfit7.admediation.model.entity.AdNetworkEntity;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Ivana Kostadinovska on 25-Nov-19.
 */
@ApiModel(value = "adNetwork", description = "Ad-Network object.")
public class AdNetwork implements Serializable{

    private Long id;
    private String uuid;
    private String name;
    private long performance;

    public AdNetwork() {

    }

    public AdNetwork(AdNetworkEntity entity) {
        this.id = entity.getId();
        this.uuid = entity.getUuid();
        this.name = entity.getName();
        this.performance = entity.getPerformance();
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for property 'uuid'.
     *
     * @return Value for property 'uuid'.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Setter for property 'uuid'.
     *
     * @param uuid Value to set for property 'uuid'.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'performance'.
     *
     * @return Value for property 'performance'.
     */
    public long getPerformance() {
        return performance;
    }

    /**
     * Setter for property 'performance'.
     *
     * @param performance Value to set for property 'performance'.
     */
    public void setPerformance(long performance) {
        this.performance = performance;
    }
}
