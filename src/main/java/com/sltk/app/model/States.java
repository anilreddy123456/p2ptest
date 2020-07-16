/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.app.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "states")
@NamedQueries({
    @NamedQuery(name = "States.findAll", query = "SELECT s FROM States s"),
    @NamedQuery(name = "States.findById", query = "SELECT s FROM States s WHERE s.id = :id"),
    @NamedQuery(name = "States.findByName", query = "SELECT s FROM States s WHERE s.name = :name"),
    @NamedQuery(name = "States.findByCountryId", query = "SELECT s FROM States s WHERE s.countryId = :countryId")})
public class States implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "country_id")
    private int countryId;

    public States() {
    }

    public States(Integer id) {
        this.id = id;
    }

    public States(Integer id, String name, int countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof States)) {
            return false;
        }
        States other = (States) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sltk.app.entity.States[ id=" + id + " ]";
    }
    
}
