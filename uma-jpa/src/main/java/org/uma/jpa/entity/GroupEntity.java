/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uma.jpa.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.uma.dto.Group;
import org.uma.dto.GroupRole;

/**
 *
 * @author piastrellatore
 */
@Entity
@Table(name = "group")
public class GroupEntity extends Group implements Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    @Column(name = "creationDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreationDate() {
        return super.getCreationDate();
    }

    @Override
    @Column(name = "description", nullable = true)
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    @Column(name = "name", nullable = false)    
    public String getName() {
        return super.getName();
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return super.getId();
    }

    @Override
    @ManyToOne(optional = true, fetch = FetchType.LAZY, targetEntity = GroupEntity.class)
    @JoinColumn(name = "groupId")
    public List<GroupRole> getGroupRoles() {
        return super.getGroupRoles();
    }
}
