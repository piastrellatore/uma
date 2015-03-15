/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uma.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.uma.dto.Address;
import org.uma.dto.User;
import org.uma.dto.UserRole;

/**
 *
 * @author piastrellatore
 */
@Entity
@Table(name = "user")
public class UserEntity extends User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public java.util.Date getCreationDate() {
        return super.getCreationDate();
    }

    @Override
    @Column(name = "expirationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getExpirationDate() {
        return super.getExpirationDate(); 
    }

    @Override
    @Column(name = "lastLoginDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getLastLoginDate() {
        return super.getLastLoginDate(); 
    }

    @Override
    @Column(name = "loginCounter")
    public int getLoginCounter() {
        return super.getLoginCounter(); 
    }

    @Override
    @Column(name = "confirmed", nullable = false)
    public Boolean getConfirmed() {
        return super.getConfirmed(); 
    }

    @Override
    @Column(name = "enabled", nullable = false)
    public Boolean getEnable() {
        return super.getEnable(); 
    }

    @Override
    @Column(name = "area", nullable = true)
    public String getArea() {
        return super.getArea(); 
    }

    @Override
    @Column(name = "division", nullable = true)    
    public String getDivision() {
        return super.getDivision(); 
    }

    @Override
    @Column(name = "company", nullable = true)
    public String getCompany() {
        return super.getCompany(); 
    }

    @Override
    @Lob
    @Column(name = "picture", nullable = true)    
    public byte[] getPicture() {
        return super.getPicture(); 
    }

    @Override
    @Column(name = "company", nullable = false)    
    public String getEmail() {
        return super.getEmail(); 
    }

    @Override
    @Column(name = "password", nullable = false)    
    public String getPassword() {
        return super.getPassword(); 
    }

    @Override
    @Column(name = "userName", nullable = false)        
    public String getUserName() {
        return super.getUserName(); 
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return super.getId(); 
    }

    @Override
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, 
            targetEntity = AddressEntity.class, mappedBy = "user")
    public List<Address> getAddresses() {
        return super.getAddresses();
    }
    
    @Override
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, 
            targetEntity = UserRoleEntity.class, mappedBy = "user")
    public List<UserRole> getUserRoles() {
        return super.getUserRoles();
    }
}
