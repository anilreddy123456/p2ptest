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

@Entity
@Table(name = "")
@NamedQueries({ @NamedQuery(name = "InvoiceTaxes.findAll", query = "SELECT i FROM InvoiceTaxes i"),
		@NamedQuery(name = "InvoiceTaxes.findByTaxDetailId", query = "SELECT i FROM InvoiceTaxes i WHERE i.taxDetailId = :taxDetailId"),
		@NamedQuery(name = "InvoiceTaxes.findByTaxDescription", query = "SELECT i FROM InvoiceTaxes i WHERE i.taxDescription = :taxDescription"),
		@NamedQuery(name = "InvoiceTaxes.findByTaxRate", query = "SELECT i FROM InvoiceTaxes i WHERE i.taxRate = :taxRate"),
		@NamedQuery(name = "InvoiceTaxes.findByTaxAmount", query = "SELECT i FROM InvoiceTaxes i WHERE i.taxAmount = :taxAmount") })
public class InvoiceTaxes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "tax_detail_id")
	private Integer taxDetailId;
	@Column(name = "tax_description")
	private String taxDescription;
	@Column(name = "tax_rate")
	private BigDecimal taxRate;
	@Column(name = "tax_amount")
	private BigDecimal taxAmount;
	@JoinColumn(name = "inv_detail_id", referencedColumnName = "inv_detail_id")
	@ManyToOne(optional = false)
	private Invoicedetails invDetailId;

	public InvoiceTaxes() {

	}

	public InvoiceTaxes(Integer taxDetailId) {
		this.taxDetailId=taxDetailId;
	}

	public Integer getTaxDetailId() {
		return taxDetailId;
	}

	public void setTaxDetailId(Integer taxDetailId) {
		this.taxDetailId = taxDetailId;
	}

	public String getTaxDescription() {
		return taxDescription;
	}

	public void setTaxDescription(String taxDescription) {
		this.taxDescription = taxDescription;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public Invoicedetails getInvDetailId() {
		return invDetailId;
	}

	public void setInvDetailId(Invoicedetails invDetailId) {
		this.invDetailId = invDetailId;
	}

	@Override
	public String toString() {
		return "InvoiceTaxes [taxDetailId=" + taxDetailId + ", taxDescription=" + taxDescription + ", taxRate="
				+ taxRate + ", taxAmount=" + taxAmount + ", invDetailId=" + invDetailId + "]";
	}

}
