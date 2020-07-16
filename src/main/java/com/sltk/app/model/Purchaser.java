package com.sltk.app.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "purchase_org")
@NamedQueries({ @NamedQuery(name = "Purchaser.findAll", query = "SELECT p FROM Purchaser p"),
		@NamedQuery(name = "Purchaser.findByPurchasingOrg", query = "SELECT p FROM Purchaser p WHERE p.purchasingOrg = :purchasingOrg"),
		@NamedQuery(name = "Purchaser.findByPurchaseOrgDescr", query = "SELECT p FROM Purchaser p WHERE p.purchaseOrgDescr = :purchaseOrgDescr") })

public class Purchaser {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "purchasing_organization")
	private String purchasingOrg;
	@Column(name = "purchasing_org_description")
	private String purchaseOrgDescr;

	public Purchaser() {

	}

	public Purchaser(String purchasingOrg) {
		this.purchasingOrg =purchasingOrg;
	}
	public Purchaser(Long purchasingOrg) {
		this.purchasingOrg =String.valueOf(purchasingOrg);
	}

	public String getPurchasingOrg() {
		return purchasingOrg;
	}

	public void setPurchasingOrg(String purchasingOrg) {
		this.purchasingOrg = purchasingOrg;
	}

	public String getPurchaseOrgDescr() {
		return purchaseOrgDescr;
	}

	public void setPurchaseOrgDescr(String purchaseOrgDescr) {
		this.purchaseOrgDescr = purchaseOrgDescr;
	}

	@Override
	public String toString() {
		return "Purchaser [purchasingOrg=" + purchasingOrg + ", purchaseOrgDescr=" + purchaseOrgDescr + "]";
	}
	
	

}
