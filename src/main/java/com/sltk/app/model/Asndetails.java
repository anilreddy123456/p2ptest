/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "asndetails")
@NamedQueries({
    @NamedQuery(name = "Asndetails.findAll", query = "SELECT a FROM Asndetails a"),
    @NamedQuery(name = "Asndetails.findByAsnDetailId", query = "SELECT a FROM Asndetails a WHERE a.asnDetailId = :asnDetailId"),
    @NamedQuery(name = "Asndetails.findByPoLineId", query = "SELECT a FROM Asndetails a WHERE a.poLineId = :poLineId"),
    @NamedQuery(name = "Asndetails.findByAsnQuantity", query = "SELECT a FROM Asndetails a WHERE a.asnQuantity = :asnQuantity")})
public class Asndetails implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asn_detail_id")
    private Integer asnDetailId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "po_line_id")
    private int poLineId;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "asn_quantity")
    private BigDecimal asnQuantity;
    
    @JoinColumn(name = "asn_id", referencedColumnName = "asn_id")
    @ManyToOne
    private Asnheader asnId;
    
    @JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
    @ManyToOne(optional = false)
    private Poheader ponumber;

    public Asndetails() {
    }

    public Asndetails(Integer asnDetailId) {
        this.asnDetailId = asnDetailId;
    }

    public Asndetails(Integer asnDetailId, int poLineId) {
        this.asnDetailId = asnDetailId;
        this.poLineId = poLineId;
    }

    public Integer getAsnDetailId() {
        return asnDetailId;
    }

    public void setAsnDetailId(Integer asnDetailId) {
        this.asnDetailId = asnDetailId;
    }

    public int getPoLineId() {
        return poLineId;
    }

    public void setPoLineId(int poLineId) {
        this.poLineId = poLineId;
    }

    public BigDecimal getAsnQuantity() {
        return asnQuantity;
    }

    public void setAsnQuantity(BigDecimal asnQuantity) {
        this.asnQuantity = asnQuantity;
    }

    public Asnheader getAsnId() {
        return asnId;
    }

    public void setAsnId(Asnheader asnId) {
        this.asnId = asnId;
    }

    public Poheader getPonumber() {
        return ponumber;
    }

    public void setPonumber(Poheader ponumber) {
        this.ponumber = ponumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asnDetailId != null ? asnDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asndetails)) {
            return false;
        }
        Asndetails other = (Asndetails) object;
        if ((this.asnDetailId == null && other.asnDetailId != null) || (this.asnDetailId != null && !this.asnDetailId.equals(other.asnDetailId))) {
            return false;
        }
        return true;
    }
/**
    @Override
    public String toString() {
        return "com.sltk.app.entity.Asndetails[ asnDetailId=" + asnDetailId + " ]";
    }
  **/  
}
