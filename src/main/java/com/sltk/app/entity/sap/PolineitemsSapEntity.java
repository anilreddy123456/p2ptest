package com.sltk.app.entity.sap;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class PolineitemsSapEntity implements Serializable {

	private String asnstatus;
	private String polineid;
	private String itemtype;
	private String deliverydate;
	private String materialnumber;
	private String description;
	private String plant;
	private String materialcatagory;
	private String orderquantity;
	private String uom;
	private String grossvalue;
	private String netvalue;
	private String balanceasnqty;
	private String previousasnqty;
	private String taxcode;
	private String ponumber;
	private String pr_number;
	private String pr_line_number;

	private List<PolineTaxSapEntity> potax = new ArrayList<PolineTaxSapEntity>();
	private List<PolineServiceSapEntity> poservicelineitem = new ArrayList<PolineServiceSapEntity>();
	public PolineitemsSapEntity() {

	}

	public String getAsnstatus() {
		return asnstatus;
	}

	public void setAsnstatus(String asnstatus) {
		this.asnstatus = asnstatus;
	}

	public String getPolineid() {
		return polineid;
	}

	public void setPolineid(String polineid) {
		this.polineid = polineid;
	}

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}

	public String getMaterialnumber() {
		return materialnumber;
	}

	public void setMaterialnumber(String materialnumber) {
		this.materialnumber = materialnumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getMaterialcatagory() {
		return materialcatagory;
	}

	public void setMaterialcatagory(String materialcatagory) {
		this.materialcatagory = materialcatagory;
	}

	public String getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(String orderquantity) {
		this.orderquantity = orderquantity;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getGrossvalue() {
		return grossvalue;
	}

	public void setGrossvalue(String grossvalue) {
		this.grossvalue = grossvalue;
	}

	public String getNetvalue() {
		return netvalue;
	}

	public void setNetvalue(String netvalue) {
		this.netvalue = netvalue;
	}

	public String getBalanceasnqty() {
		return balanceasnqty;
	}

	public void setBalanceasnqty(String balanceasnqty) {
		this.balanceasnqty = balanceasnqty;
	}

	public String getPreviousasnqty() {
		return previousasnqty;
	}

	public void setPreviousasnqty(String previousasnqty) {
		this.previousasnqty = previousasnqty;
	}

	public String getTaxcode() {
		return taxcode;
	}

	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}

	public String getPonumber() {
		return ponumber;
	}

	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}

	public String getPr_number() {
		return pr_number;
	}

	public void setPr_number(String pr_number) {
		this.pr_number = pr_number;
	}

	public String getPr_line_number() {
		return pr_line_number;
	}

	public void setPr_line_number(String pr_line_number) {
		this.pr_line_number = pr_line_number;
	}

	public List<PolineTaxSapEntity> getPotax() {
		return potax;
	}

	public void setPotax(List<PolineTaxSapEntity> potax) {
		this.potax = potax;
	}
	public List<PolineServiceSapEntity> getPoservicelineitem() {
		return poservicelineitem;
	}

	public void setPoservicelineitem(List<PolineServiceSapEntity> poservicelineitem) {
		this.poservicelineitem = poservicelineitem;
	}

	@Override
	public String toString() {
		return "PolineitemsSapEntity [asnstatus=" + asnstatus + ", polineid=" + polineid + ", itemtype=" + itemtype
				+ ", deliverydate=" + deliverydate + ", materialnumber=" + materialnumber + ", description="
				+ description + ", plant=" + plant + ", materialcatagory=" + materialcatagory + ", orderquantity="
				+ orderquantity + ", uom=" + uom + ", grossvalue=" + grossvalue + ", netvalue=" + netvalue
				+ ", balanceasnqty=" + balanceasnqty + ", previousasnqty=" + previousasnqty + ", taxcode=" + taxcode
				+ ", ponumber=" + ponumber + ", pr_number=" + pr_number + ", potax=" + potax + ", poservicelineitem="
				+ poservicelineitem + "]";
	}

	
}
