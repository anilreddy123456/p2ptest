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

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "company")
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByCompId", query = "SELECT c FROM Company c WHERE c.compId = :compId"),
    @NamedQuery(name = "Company.findByCompCode", query = "SELECT c FROM Company c WHERE c.compCode = :compCode"),
    @NamedQuery(name = "Company.findByCompName", query = "SELECT c FROM Company c WHERE c.compName = :compName"),
    @NamedQuery(name = "Company.findByCompRegNo", query = "SELECT c FROM Company c WHERE c.compRegNo = :compRegNo"),
    @NamedQuery(name = "Company.findByCompType", query = "SELECT c FROM Company c WHERE c.compType = :compType"),
    @NamedQuery(name = "Company.findByStatus", query = "SELECT c FROM Company c WHERE c.status = :status"),
    @NamedQuery(name = "Company.findByAddress", query = "SELECT c FROM Company c WHERE c.address = :address"),
    @NamedQuery(name = "Company.findByCity", query = "SELECT c FROM Company c WHERE c.city = :city"),
    @NamedQuery(name = "Company.findByState", query = "SELECT c FROM Company c WHERE c.state = :state"),
    @NamedQuery(name = "Company.findByZip", query = "SELECT c FROM Company c WHERE c.zip = :zip"),
    @NamedQuery(name = "Company.findByCountry", query = "SELECT c FROM Company c WHERE c.country = :country"),
    @NamedQuery(name = "Company.findByGstNo", query = "SELECT c FROM Company c WHERE c.gstNo = :gstNo"),
    @NamedQuery(name = "Company.findByPan", query = "SELECT c FROM Company c WHERE c.pan = :pan"),
    @NamedQuery(name = "Company.findByOther", query = "SELECT c FROM Company c WHERE c.other = :other"),
    @NamedQuery(name = "Company.findByCreatedBy", query = "SELECT c FROM Company c WHERE c.createdBy = :createdBy"),
    @NamedQuery(name = "Company.findByCreatedDate", query = "SELECT c FROM Company c WHERE c.createdDate = :createdDate"),
    @NamedQuery(name = "Company.findByLastModifiedBy", query = "SELECT c FROM Company c WHERE c.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "Company.findByLastModifiedDate", query = "SELECT c FROM Company c WHERE c.lastModifiedDate = :lastModifiedDate")})
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comp_id")
    private Integer compId;
    
    @Column(name = "comp_code")
    private String compCode;
    
    @Column(name = "comp_name")
    private String compName;
    
    @Column(name = "purchase_org")
    private String purchaseOrg;
    
    @Column(name = "account_group")
    private String accountGroup;
    
    @Column(name = "comp_reg_no")
    private String compRegNo;
    
    @Column(name = "comp_type")
    private String compType;
    
    @Column(name = "status")
    private short status;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "zip")
    private String zip;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "gst_no")
    private String gstNo;
    
    @Column(name = "pan")
    private String pan;
    
    @Column(name = "other")
    private String other;
    
    @Column(name = "currency")
    private String currency;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compId")
    private List<Poheader> poheaderList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compId")
    private List<Invoices> invoicesList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Vendor> vendorList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compId")
    private List<User> userList;

    public Company() {
    }

    public Company(Integer compId) {
        this.compId = compId;
    }

    public Company(Integer compId, String compCode, String compName, short status, String createdBy, String lastModifiedBy) {
        this.compId = compId;
        this.compCode = compCode;
        this.compName = compName;
        this.status = status;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getCompCode() {
        return compCode;
    }

    public void setCompCode(String compCode) {
        this.compCode = compCode;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getPurchaseOrg()
	{
		return purchaseOrg;
	}

	public void setPurchaseOrg(String purchaseOrg)
	{
		this.purchaseOrg = purchaseOrg;
	}

	public String getAccountGroup()
	{
		return accountGroup;
	}

	public void setAccountGroup(String accountGroup)
	{
		this.accountGroup = accountGroup;
	}

	public String getCompRegNo() {
        return compRegNo;
    }

    public void setCompRegNo(String compRegNo) {
        this.compRegNo = compRegNo;
    }

    public String getCompType() {
        return compType;
    }

    public void setCompType(String compType) {
        this.compType = compType;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
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

    public List<Poheader> getPoheaderList() {
        return poheaderList;
    }

    public void setPoheaderList(List<Poheader> poheaderList) {
        this.poheaderList = poheaderList;
    }

    public List<Invoices> getInvoicesList() {
        return invoicesList;
    }

    public void setInvoicesList(List<Invoices> invoicesList) {
        this.invoicesList = invoicesList;
    }

    public List<Vendor> getVendorList() {
        return vendorList;
    }

    public void setVendorList(List<Vendor> vendorList) {
        this.vendorList = vendorList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compId != null ? compId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.compId == null && other.compId != null) || (this.compId != null && !this.compId.equals(other.compId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sltk.app.entity.Company[ compId=" + compId + " ]";
    }
    
}
