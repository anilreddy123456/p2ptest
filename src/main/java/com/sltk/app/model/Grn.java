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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "grn")
@NamedQueries({ @NamedQuery(name = "Grn.findAll", query = "SELECT g FROM Grn g"),
		@NamedQuery(name = "Grn.findByGrnNumber", query = "SELECT g FROM Grn g WHERE g.grnNumber = :grnNumber"),
		@NamedQuery(name = "Grn.findByPonumber", query = "SELECT g FROM Grn g WHERE g.ponumber = :ponumber"),
		@NamedQuery(name = "Grn.findByGrnCreatedBy", query = "SELECT g FROM Grn g WHERE g.grnCreatedBy = :grnCreatedBy"),
		@NamedQuery(name = "Grn.findByGrnCreatedDate", query = "SELECT g FROM Grn g WHERE g.grnCreatedDate = :grnCreatedDate"),
		@NamedQuery(name = "Grn.findByGrnPostingDate", query = "SELECT g FROM Grn g WHERE g.grnPostingDate = :grnPostingDate") })
public class Grn implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "grn_number")
	private String grnNumber;

	@Size(max = 250)
	@Column(name = "grn_created_by")
	private String grnCreatedBy;

	@Column(name = "grn_created_date")
	// @Temporal(TemporalType.TIMESTAMP)
	private String grnCreatedDate;

	@Column(name = "grn_posting_date")
	// @Temporal(TemporalType.TIMESTAMP)
	private String grnPostingDate;
	/**
	 * @Column(name = "ponumber") private String ponumber;
	 * 
	 **/
	@JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
	@ManyToOne(optional = false)
	private Poheader ponumber;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grnNumber")
	private List<Grndetails> grndetailsList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grnNumber")
	private List<Invoicedetails> invoicedetailsList;

	public Grn() {
	}

	public Grn(String grnNumber) {
		this.grnNumber = grnNumber;
	}

	public Grn(Long grnNumber) {
		this.grnNumber = String.valueOf(grnNumber);
	}

	public String getGrnNumber() {
		return grnNumber;
	}

	public void setGrnNumber(String grnNumber) {
		this.grnNumber = grnNumber;
	}

	public String getGrnCreatedBy() {
		return grnCreatedBy;
	}

	public void setGrnCreatedBy(String grnCreatedBy) {
		this.grnCreatedBy = grnCreatedBy;
	}

	public String getGrnCreatedDate() {
		return grnCreatedDate;
	}

	public void setGrnCreatedDate(String grnCreatedDate) {
		this.grnCreatedDate = grnCreatedDate;
	}

	public String getGrnPostingDate() {
		return grnPostingDate;
	}

	public void setGrnPostingDate(String grnPostingDate) {
		this.grnPostingDate = grnPostingDate;
	}

	public Poheader getPonumber() {
		return ponumber;
	}

	public void setPonumber(Poheader ponumber) {
		this.ponumber = ponumber;
	}

	/**
	 * public String getPonumber() { return ponumber; }
	 * 
	 * public void setPonumber(String ponumber) { this.ponumber = ponumber; }
	 **/
	public List<Grndetails> getGrndetailsList() {
		return grndetailsList;
	}

	public void setGrndetailsList(List<Grndetails> grndetailsList) {
		this.grndetailsList = grndetailsList;
	}

	public List<Invoicedetails> getInvoicedetailsList() {
		return invoicedetailsList;
	}

	public void setInvoicedetailsList(List<Invoicedetails> invoicedetailsList) {
		this.invoicedetailsList = invoicedetailsList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (grnNumber != null ? grnNumber.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Grn)) {
			return false;
		}
		Grn other = (Grn) object;
		if ((this.grnNumber == null && other.grnNumber != null)
				|| (this.grnNumber != null && !this.grnNumber.equals(other.grnNumber))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sltk.app.entity.Grn[ grnNumber=" + grnNumber + " ]";
	}

}
