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
import org.uma.dto.Group;
import org.uma.dto.GroupRole;
import org.uma.dto.Role;

/**
 *
 * @author piastrellatore
 */
@Entity
public class GroupRoleEntity extends GroupRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = RoleEntity.class)
    @JoinColumn(name = "roleId")
    public Role getRole() {
        return super.getRole();
    }

    @Override
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = GroupEntity.class)
    @JoinColumn(name = "groupId")
    public Group getGroup() {
        return super.getGroup();
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return super.getId();
    }
}
