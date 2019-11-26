package com.outfit7.admediation.model.entity;

import javax.persistence.*;

/**
 * Created by Ivana Kostadinovska on 25-Nov-19.
 */
@Entity
@Table(name = "AD_NETWORKS")

public class AdNetworkEntity {
    private Long id;
    private String uuid;
    private String name;
    private long performance;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for property 'uuid'.
     *
     * @return Value for property 'uuid'.
     */

    @Column(name = "UUID")
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
    @Basic
    @Column(name = "NAME")
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
    @Basic
    @Column(name = "PERFORMANCE")
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
