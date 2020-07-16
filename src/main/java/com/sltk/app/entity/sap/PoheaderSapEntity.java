package com.sltk.app.entity.sap;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


public class PoheaderSapEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String ponumber;    
    private String vendorsapcode;    
    private String description;   
    private String potype;    
    private String purchaser;   
    private String othercharges;   
    private String netvalue;   
    private String taxvalue;   
    private String grossvalue;    
    private String currency;   
    private String createddate;
    private String docdate;
    private String lastmodifiedby;  
    private String lastmodifieddate;
    private String pay_term;
    
    private List<PolineitemsSapEntity> polineitemslist = new ArrayList<PolineitemsSapEntity>();
       
    
    public PoheaderSapEntity() {
    }


	public String getPonumber() {
		return ponumber;
	}


	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}
	/**
	public void setPonumber(Long ponumber) {
		this.ponumber = String.valueOf(ponumber);
	}
**/

	public String getVendorsapcode() {
		return vendorsapcode;
	}


	public void setVendorsapcode(String vendorsapcode) {
		this.vendorsapcode = vendorsapcode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getPotype() {
		return potype;
	}


	public void setPotype(String potype) {
		this.potype = potype;
	}


	public String getPurchaser() {
		return purchaser;
	}


	public void setPurchaser(String purchaser) {
		this.purchaser = purchaser;
	}


	public String getOthercharges() {
		return othercharges;
	}


	public void setOthercharges(String othercharges) {
		this.othercharges = othercharges;
	}


	public String getNetvalue() {
		return netvalue;
	}


	public void setNetvalue(String netvalue) {
		this.netvalue = netvalue;
	}


	public String getTaxvalue() {
		return taxvalue;
	}


	public void setTaxvalue(String taxvalue) {
		this.taxvalue = taxvalue;
	}


	public String getGrossvalue() {
		return grossvalue;
	}


	public void setGrossvalue(String grossvalue) {
		this.grossvalue = grossvalue;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getCreateddate() {
		return createddate;
	}


	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}


	public String getDocdate() {
		return docdate;
	}


	public void setDocdate(String docdate) {
		this.docdate = docdate;
	}


	public String getLastmodifiedby() {
		return lastmodifiedby;
	}


	public void setLastmodifiedby(String lastmodifiedby) {
		this.lastmodifiedby = lastmodifiedby;
	}


	public String getLastmodifieddate() {
		return lastmodifieddate;
	}


	public void setLastmodifieddate(String lastmodifieddate) {
		this.lastmodifieddate = lastmodifieddate;
	}


	public List<PolineitemsSapEntity> getPolineitemslist() {
		return polineitemslist;
	}


	public void setPolineitemslist(List<PolineitemsSapEntity> polineitemslist) {
		this.polineitemslist = polineitemslist;
	}


	public String getPay_term() {
		return pay_term;
	}


	public void setPay_term(String pay_term) {
		this.pay_term = pay_term;
	}


	@Override
	public String toString() {
		return "PoheaderSapEntity [ponumber=" + ponumber + ", vendorsapcode=" + vendorsapcode + ", description="
				+ description + ", potype=" + potype + ", purchaser=" + purchaser + ", othercharges=" + othercharges
				+ ", netvalue=" + netvalue + ", taxvalue=" + taxvalue + ", grossvalue=" + grossvalue + ", currency="
				+ currency + ", createddate=" + createddate + ", docdate=" + docdate + ", lastmodifiedby="
				+ lastmodifiedby + ", lastmodifieddate=" + lastmodifieddate + ", pay_term=" + pay_term
				+ ", polineitemslist=" + polineitemslist + "]";
	}


	
     
}
