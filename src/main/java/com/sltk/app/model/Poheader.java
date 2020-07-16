/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.joda.time.format.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.*;







/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "poheader")
@NamedQueries({
    @NamedQuery(name = "Poheader.findAll", query = "SELECT p FROM Poheader p"),
    @NamedQuery(name = "Poheader.findByPonumber", query = "SELECT p FROM Poheader p WHERE p.ponumber = :ponumber"),
    @NamedQuery(name = "Poheader.findByVendorSapCode", query = "SELECT p FROM Poheader p WHERE p.vendorSapCode = :vendorSapCode"),
    @NamedQuery(name = "Poheader.findByDescription", query = "SELECT p FROM Poheader p WHERE p.description = :description"),
    @NamedQuery(name = "Poheader.findByPotype", query = "SELECT p FROM Poheader p WHERE p.potype = :potype"),
    @NamedQuery(name = "Poheader.findByPurchaser", query = "SELECT p FROM Poheader p WHERE p.purchaser = :purchaser"),
    @NamedQuery(name = "Poheader.findByNetValue", query = "SELECT p FROM Poheader p WHERE p.netValue = :netValue"),
    @NamedQuery(name = "Poheader.findByTaxValue", query = "SELECT p FROM Poheader p WHERE p.taxValue = :taxValue"),
    @NamedQuery(name = "Poheader.findByGrossValue", query = "SELECT p FROM Poheader p WHERE p.grossValue = :grossValue"),
    @NamedQuery(name = "Poheader.findByCurrency", query = "SELECT p FROM Poheader p WHERE p.currency = :currency"),
    @NamedQuery(name = "Poheader.findByCreatedDate", query = "SELECT p FROM Poheader p WHERE p.createdDate = :createdDate"),
    @NamedQuery(name = "Poheader.findByDocDate", query = "SELECT p FROM Poheader p WHERE p.docDate = :docDate"),
    @NamedQuery(name = "Poheader.findByLastModifiedBy", query = "SELECT p FROM Poheader p WHERE p.lastModifiedBy = :lastModifiedBy"),
    @NamedQuery(name = "Poheader.findByLastModifiedDate", query = "SELECT p FROM Poheader p WHERE p.lastModifiedDate = :lastModifiedDate"),
    @NamedQuery(name = "Poheader.findByPayTerms", query = "SELECT p FROM Poheader p WHERE p.payTerms = :payTerms")})
public class Poheader implements Serializable {

    private static final long serialVersionUID = 1L;
   
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ponumber")
    private Long ponumber;
    
    @Column(name = "vendor_sap_code")
    private String vendorSapCode;
    
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    
    @Size(max = 200)
    @Column(name = "potype")
    private String potype;
    
    @Size(max = 200)
    @Column(name = "purchaser")
    private String purchaser;
    
    @Column(name = "other_charges")
    private BigDecimal otherCharges;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "net_value")
    private BigDecimal netValue;
    
    @Column(name = "tax_value")
    private BigDecimal taxValue;
    
    @Column(name = "gross_value")
    private BigDecimal grossValue;
    
    @Size(max = 10)
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "created_date")
   // @Temporal(TemporalType.TIMESTAMP)
   // @DateTimeFormat(iso = ISO.DATE_TIME)
    private String createdDate;
    
    @Column(name = "doc_date")
    private String docDate;
    
    @Size(max = 150)
    @Column(name = "last_modified_by")
    private String lastModifiedBy;
    
    @Column(name = "last_modified_date")
    //@Temporal(TemporalType.TIMESTAMP)
    private String lastModifiedDate;
    
    @Column(name ="pay_term")
    private String payTerms;
    
    @JoinColumn(name = "comp_id", referencedColumnName = "comp_id")
    @ManyToOne
    private Company compId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber")
    private List<Invoicedetails> invoicedetailsList;

   // @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber")
    private List<Polineitems> polineitemsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber")
    private List<PolineItemServices> polineitemsServiceList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber")
    private List<Asndetails> asndetailsList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber")
    private List<Asnheader> asnheaderList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber")
    private List<Grn> grnList;
    
    /**
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ponumber")
    private List<Grndetails> grnDetailList;
	**/

    public Poheader() {
    }

    public Poheader(Long ponumber) {
        this.ponumber = ponumber;
    }
    public Poheader(String ponumber) {
        this.ponumber = Long.parseLong(ponumber);
    }

    public Long getPonumber() {
        return ponumber;
    }

    public void setPonumber(Long ponumber) {
        this.ponumber = ponumber;
    }

    public String getVendorSapCode() {
        return vendorSapCode;
    }

    public void setVendorSapCode(String vendorSapCode) {
        this.vendorSapCode = vendorSapCode;
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

    public BigDecimal getOtherCharges()
	{
		return otherCharges;
	}

	public void setOtherCharges(BigDecimal otherCharges)
	{
		this.otherCharges = otherCharges;
	}

	public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public BigDecimal getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(BigDecimal taxValue) {
        this.taxValue = taxValue;
    }

    public BigDecimal getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(BigDecimal grossValue) {
        this.grossValue = grossValue;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getDocDate() {
		return docDate;
	}

	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}

	public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Company getCompId() {
        return compId;
    }

    public void setCompId(Company compId) {
        this.compId = compId;
    }

    public List<Invoicedetails> getInvoicedetailsList() {
        return invoicedetailsList;
    }

    public void setInvoicedetailsList(List<Invoicedetails> invoicedetailsList) {
        this.invoicedetailsList = invoicedetailsList;
    }

    public List<Polineitems> getPolineitemsList() {
        return polineitemsList;
    }

    public void setPolineitemsList(List<Polineitems> polineitemsList) {
        this.polineitemsList = polineitemsList;
    }

    public List<Asndetails> getAsndetailsList() {
        return asndetailsList;
    }

    public void setAsndetailsList(List<Asndetails> asndetailsList) {
        this.asndetailsList = asndetailsList;
    }

    public List<Asnheader> getAsnheaderList() {
        return asnheaderList;
    }

    public void setAsnheaderList(List<Asnheader> asnheaderList) {
        this.asnheaderList = asnheaderList;
    }

    public List<Grn> getGrnList()
	{
		return grnList;
	}

	public void setGrnList(List<Grn> grnList)
	{
		this.grnList = grnList;
	}
	

	public String getPayTerms() {
		return payTerms;
	}

	public void setPayTerms(String payTerms) {
		this.payTerms = payTerms;
	}

	public List<PolineItemServices> getPolineitemsServiceList() {
		return polineitemsServiceList;
	}

	public void setPolineitemsServiceList(List<PolineItemServices> polineitemsServiceList) {
		this.polineitemsServiceList = polineitemsServiceList;
	}

	/**
	public List<Grndetails> getGrnDetailList()
	{
		return grnDetailList;
	}

	public void setGrnDetailList(List<Grndetails> grnDetailList)
	{
		this.grnDetailList = grnDetailList;
	}
	**/

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (ponumber != null ? ponumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Poheader)) {
            return false;
        }
        Poheader other = (Poheader) object;
        if ((this.ponumber == null && other.ponumber != null) || (this.ponumber != null && !this.ponumber.equals(other.ponumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sltk.app.entity.Poheader[ ponumber=" + ponumber + " ]";
    }
    
}
