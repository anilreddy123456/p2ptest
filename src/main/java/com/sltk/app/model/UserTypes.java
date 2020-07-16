/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.app.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "user_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserTypes.findAll", query = "SELECT u FROM UserTypes u"),
    @NamedQuery(name = "UserTypes.findByUsertypeId", query = "SELECT u FROM UserTypes u WHERE u.usertypeId = :usertypeId"),
    @NamedQuery(name = "UserTypes.findByUsertypeName", query = "SELECT u FROM UserTypes u WHERE u.usertypeName = :usertypeName"),
    @NamedQuery(name = "UserTypes.findByUsertypeDesc", query = "SELECT u FROM UserTypes u WHERE u.usertypeDesc = :usertypeDesc"),
    @NamedQuery(name = "UserTypes.findByUsertypeStatus", query = "SELECT u FROM UserTypes u WHERE u.usertypeStatus = :usertypeStatus"),
    @NamedQuery(name = "UserTypes.findByCreatedBy", query = "SELECT u FROM UserTypes u WHERE u.createdBy = :createdBy"),
    @NamedQuery(name = "UserTypes.findByCreatedDate", query = "SELECT u FROM UserTypes u WHERE u.createdDate = :createdDate"),
    @NamedQuery(name = "UserTypes.findByLastModifiedBy", query = "SELECT u FROM UserTypes u WHERE u.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "UserTypes.findByLastModifiedDate", query = "SELECT u FROM UserTypes u WHERE u.lastModifiedDate = :lastModifiedDate")})
public class UserTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usertype_id")
    private Integer usertypeId;
    
    @Column(name = "usertype_name")
    private String usertypeName;
    
    @Column(name = "usertype_desc")
    private String usertypeDesc;
    
    @Column(name = "usertype_status")
    private short usertypeStatus;
    
    @Column(name = "created_by")
    private String createdBy;
    
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
    
    @OneToMany(mappedBy = "usertype")
    private List<User> userList;

    public UserTypes() {
    }

    public UserTypes(Integer usertypeId) {
        this.usertypeId = usertypeId;
    }

    public UserTypes(Integer usertypeId, String usertypeName, short usertypeStatus, String createdBy, String lastModifiedBy) {
        this.usertypeId = usertypeId;
        this.usertypeName = usertypeName;
        this.usertypeStatus = usertypeStatus;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getUsertypeId() {
        return usertypeId;
    }

    public void setUsertypeId(Integer usertypeId) {
        this.usertypeId = usertypeId;
    }

    public String getUsertypeName() {
        return usertypeName;
    }

    public void setUsertypeName(String usertypeName) {
        this.usertypeName = usertypeName;
    }

    public String getUsertypeDesc() {
        return usertypeDesc;
    }

    public void setUsertypeDesc(String usertypeDesc) {
        this.usertypeDesc = usertypeDesc;
    }

    public short getUsertypeStatus() {
        return usertypeStatus;
    }

    public void setUsertypeStatus(short usertypeStatus) {
        this.usertypeStatus = usertypeStatus;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usertypeId != null ? usertypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserTypes)) {
            return false;
        }
        UserTypes other = (UserTypes) object;
        if ((this.usertypeId == null && other.usertypeId != null) || (this.usertypeId != null && !this.usertypeId.equals(other.usertypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sltk.app.entity.UserTypes[ usertypeId=" + usertypeId + " ]";
    }
    
}
