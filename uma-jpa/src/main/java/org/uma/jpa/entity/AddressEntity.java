/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uma.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.uma.dto.Address;
import org.uma.dto.User;

/**
 *
 * @author piastrellatore
 */
@Entity(name = "address")
public class AddressEntity extends Address implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Override
    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreationDate() {
        return super.getCreationDate();
    }

    @Override
    @Column(name = "priority", nullable = false)
    public Integer getPriority() {
        return super.getPriority();
    }

    @Override
    @Column(name = "business", nullable = false)
    public Boolean getBusiness() {
        return super.getBusiness();
    }

    @Override
    @Column(name = "delivery", nullable = false)
    public Boolean getDelivery() {
        return super.getDelivery();
    }

    @Override
    @Column(name = "province", nullable = false)
    public String getProvince() {
        return super.getProvince();
    }

    @Override
    @Column(name = "number", nullable = false)
    public String getNumber() {
        return super.getNumber();
    }

    @Override
    @Column(name = "country", nullable = false)
    public String getCountry() {
        return super.getCountry();
    }

    @Override
    @Column(name = "street", nullable = false)
    public String getStreet() {
        return super.getStreet();
    }

    @Override
    @Column(name = "zip", nullable = false)
    public String getZip() {
        return super.getZip();
    }

    @Override
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = UserEntity.class)
    @JoinColumn(name = "userId")
    public User getUser() {
        return super.getUser();
    }
}
