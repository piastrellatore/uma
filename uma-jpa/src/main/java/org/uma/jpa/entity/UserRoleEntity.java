/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uma.jpa.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.uma.dto.Role;
import org.uma.dto.User;
import org.uma.dto.UserRole;

/**
 *
 * @author piastrellatore
 */
@Entity
@Table(name = "userrole")
public class UserRoleEntity extends UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Override
    public Long getId() {
        return super.getId();
    }

    @Override
    @ManyToOne(optional = true, fetch = FetchType.LAZY, targetEntity = RoleEntity.class)
    @JoinColumn(name = "roleId")
    public Role getRole() {
        return super.getRole();
    }

    @Override
    @ManyToOne(optional = true, fetch = FetchType.LAZY, targetEntity = UserEntity.class)
    @JoinColumn(name = "userId")
    public User getUser() {
        return super.getUser();
    }

}
