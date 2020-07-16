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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "grndetails")
@NamedQueries({ @NamedQuery(name = "Grndetails.findAll", query = "SELECT g FROM Grndetails g"),
		@NamedQuery(name = "Grndetails.findByGrnDetailId", query = "SELECT g FROM Grndetails g WHERE g.grnDetailId = :grnDetailId"),
		@NamedQuery(name = "Grndetails.findByPoLineId", query = "SELECT g FROM Grndetails g WHERE g.poLineId = :poLineId"),
		@NamedQuery(name = "Grndetails.findByPlant", query = "SELECT g FROM Grndetails g WHERE g.plant = :plant"),
		@NamedQuery(name = "Grndetails.findByQuantity", query = "SELECT g FROM Grndetails g WHERE g.quantity = :quantity"),
		@NamedQuery(name = "Grndetails.findByGrnMovementType", query = "SELECT g FROM Grndetails g WHERE g.grnMovementType = :grnMovementType"),
		@NamedQuery(name = "Grndetails.findByMatShortDesc", query = "SELECT g FROM Grndetails g WHERE g.matShortDesc = :matShortDesc"),
		@NamedQuery(name = "Grndetails.findByBillOfLading", query = "SELECT g FROM Grndetails g WHERE g.billOfLading = :billOfLading") })
public class Grndetails implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "grn_detail_id")
	private Integer grnDetailId;
/**
	@Column(name = "ponumber")
	private String ponumber;
	**/
	@Column(name = "po_line_id")
	private String poLineId;

	@Size(max = 10)
	@Column(name = "plant")
	private String plant;

	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "quantity")
	private BigDecimal quantity;

	@Size(max = 255)
	@Column(name = "grn_movement_type")
	private String grnMovementType;

	@Column(name = "grn_item_id")
	private String grnItemId;

	@Size(max = 255)
	@Column(name = "mat_short_desc")
	private String matShortDesc;

	@Size(max = 255)
	@Column(name = "bill_of_lading")
	private String billOfLading;

	@Transient
	private BigDecimal grossValue;

	@JoinColumn(name = "grn_number", referencedColumnName = "grn_number")
	@ManyToOne(optional = false)
	private Grn grnNumber;
/**
	@Column(name = "line_id")
	private int lineId;
**/

	@JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
	@ManyToOne(optional = false)
	private Poheader ponumber;
	 

	
	  @JoinColumn(name = "line_id", referencedColumnName = "line_id")
	  @ManyToOne(optional = false) 
	  private Polineitems lineId;
	 

	public Grndetails() {
	}

	public Grndetails(Integer grnDetailId) {
		this.grnDetailId = grnDetailId;
	}

	public Grndetails(String grnDetailId) {
		this.grnDetailId = Integer.parseInt(grnDetailId);
	}

	public Integer getGrnDetailId() {
		return grnDetailId;
	}

	public void setGrnDetailId(Integer grnDetailId) {
		this.grnDetailId = grnDetailId;
	}
/**
	public String getPonumber() {
		return ponumber;
	}

	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}
**/
	public String getPoLineId() {
		return poLineId;
	}

	public void setPoLineId(String poLineId) {
		this.poLineId = poLineId;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public String getGrnMovementType() {
		return grnMovementType;
	}

	public void setGrnMovementType(String grnMovementType) {
		this.grnMovementType = grnMovementType;
	}

	public String getGrnItemId() {
		return grnItemId;
	}

	public void setGrnItemId(String grnItemId) {
		this.grnItemId = grnItemId;
	}

	public String getMatShortDesc() {
		return matShortDesc;
	}

	public void setMatShortDesc(String matShortDesc) {
		this.matShortDesc = matShortDesc;
	}

	public String getBillOfLading() {
		return billOfLading;
	}

	public void setBillOfLading(String billOfLading) {
		this.billOfLading = billOfLading;
	}

	public BigDecimal getGrossValue() {
		return grossValue;
	}

	public void setGrossValue(BigDecimal grossValue) {
		this.grossValue = grossValue;
	}

	public Grn getGrnNumber() {
		return grnNumber;
	}

	public void setGrnNumber(Grn grnNumber) {
		this.grnNumber = grnNumber;
	}
/**
	public int getLineId() {
		return lineId;
	}

	public void setLineId(int lineId) {
		this.lineId = lineId;
	}

**/
	public Polineitems getLineId() {
		return lineId;
	}

	public void setLineId(Polineitems lineId) {
		this.lineId = lineId;
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
		hash += (grnDetailId != null ? grnDetailId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Grndetails)) {
			return false;
		}
		Grndetails other = (Grndetails) object;
		if ((this.grnDetailId == null && other.grnDetailId != null)
				|| (this.grnDetailId != null && !this.grnDetailId.equals(other.grnDetailId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sltk.app.entity.Grndetails[ grnDetailId=" + grnDetailId + " ]";
	}

}
