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
import javax.persistence.Table;

@Entity
@Table(name="polineitemtax")
public class PolineItemTaxes implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name="tax_detail_id")
	private int taxDetailId;
	
	@Column(name="tax_description")
	private String taxDescription;
	
	@Column(name="tax_rate")
	private BigDecimal taxRate;
	
	@JoinColumn(name = "line_id", referencedColumnName = "line_id")
    @ManyToOne(optional = false)
	private Polineitems line_id;
	
	public PolineItemTaxes() {
		
	}
	public PolineItemTaxes(int taxDetailId) {
		this.taxDetailId=taxDetailId;
	}
	public PolineItemTaxes(String taxDetailId) {
		this.taxDetailId=Integer.parseInt(taxDetailId);
	}
	public int getTaxDetailId() {
		return taxDetailId;
	}
	public void setTaxDetailId(int taxDetailId) {
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
	public Polineitems getLine_id() {
		return line_id;
	}
	public void setLine_id(Polineitems line_id) {
		this.line_id = line_id;
	}
	@Override
	public String toString() {
		return "PolineItemTaxes [taxDetailId=" + taxDetailId + ", taxDescription=" + taxDescription + ", taxRate="
				+ taxRate + ", line_id=" + line_id + "]";
	}
	
	
	
}
