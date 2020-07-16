/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "asnheader")
@NamedQueries({
    @NamedQuery(name = "Asnheader.findAll", query = "SELECT a FROM Asnheader a"),
    @NamedQuery(name = "Asnheader.findByAsnId", query = "SELECT a FROM Asnheader a WHERE a.asnId = :asnId"),
    @NamedQuery(name = "Asnheader.findByAsnNo", query = "SELECT a FROM Asnheader a WHERE a.asnNo = :asnNo"),
    @NamedQuery(name = "Asnheader.findByAsnCreateDate", query = "SELECT a FROM Asnheader a WHERE a.asnCreateDate = :asnCreateDate"),
    @NamedQuery(name = "Asnheader.findByCustomerName", query = "SELECT a FROM Asnheader a WHERE a.customerName = :customerName"),
    @NamedQuery(name = "Asnheader.findByDeliveryDate", query = "SELECT a FROM Asnheader a WHERE a.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "Asnheader.findByModeOfTransport", query = "SELECT a FROM Asnheader a WHERE a.modeOfTransport = :modeOfTransport"),
    @NamedQuery(name = "Asnheader.findByShippingDate", query = "SELECT a FROM Asnheader a WHERE a.shippingDate = :shippingDate"),
    @NamedQuery(name = "Asnheader.findByAsnStatus", query = "SELECT a FROM Asnheader a WHERE a.asnStatus = :asnStatus"),
    @NamedQuery(name = "Asnheader.findByTransportCode", query = "SELECT a FROM Asnheader a WHERE a.transportCode = :transportCode"),
    @NamedQuery(name = "Asnheader.findByShippingAddress", query = "SELECT a FROM Asnheader a WHERE a.shippingAddress = :shippingAddress")})
public class Asnheader implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "asn_id")
    private Integer asnId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "asn_no")
    private String asnNo;
    
    @Column(name = "sap_asn_no")
    private String sapAsnNo;
    
    @Column(name = "asn_create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asnCreateDate;
    
    @Size(max = 255)
    @Column(name = "customer_name")
    private String customerName;
    
    @Column(name = "delivery_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    
    @Size(max = 255)
    @Column(name = "mode_of_transport")
    private String modeOfTransport;
    
    @Column(name = "shipping_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippingDate;
    
    @Size(max = 255)
    @Column(name = "asn_status")
    private String asnStatus;
    
    @Column(name = "transport_code")
    private String transportCode;
    
    @Size(max = 255)
    @Column(name = "shipping_address")
    private String shippingAddress;
    
    @OneToMany(mappedBy = "asnId",cascade = CascadeType.ALL)
    private List<Asndetails> asndetailsList;
    
    @JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
    @ManyToOne(optional = false)
    private Poheader ponumber;

	@Transient
	private List<Integer> selectedLineItem; 
	
	@Transient
	private List<BigDecimal> selectedASNQty;
	
	@Transient
	private String asnCreateDateString;
	
	@Transient
	private String deliveryDateString;
	
	@Transient
	private String shippingDateString;
    
    public Asnheader() {
    }

    public Asnheader(Integer asnId) {
        this.asnId = asnId;
    }

    public Asnheader(Integer asnId, String asnNo) {
        this.asnId = asnId;
        this.asnNo = asnNo;
    }

    public Integer getAsnId() {
        return asnId;
    }

    public void setAsnId(Integer asnId) {
        this.asnId = asnId;
    }

    public String getAsnNo() {
        return asnNo;
    }

    public void setAsnNo(String asnNo) {
        this.asnNo = asnNo;
    }

    public String getSapAsnNo()
	{
		return sapAsnNo;
	}

	public void setSapAsnNo(String sapAsnNo)
	{
		this.sapAsnNo = sapAsnNo;
	}

	public Date getAsnCreateDate() {
        return asnCreateDate;
    }

    public void setAsnCreateDate(Date asnCreateDate) {
        this.asnCreateDate = asnCreateDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getModeOfTransport() {
        return modeOfTransport;
    }

    public void setModeOfTransport(String modeOfTransport) {
        this.modeOfTransport = modeOfTransport;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }

    public String getAsnStatus() {
        return asnStatus;
    }

    public void setAsnStatus(String asnStatus) {
        this.asnStatus = asnStatus;
    }

    public String getTransportCode() {
        return transportCode;
    }

    public void setTransportCode(String transportCode) {
        this.transportCode = transportCode;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Asndetails> getAsndetailsList() {
        return asndetailsList;
    }

    public void setAsndetailsList(List<Asndetails> asndetailsList) {
        this.asndetailsList = asndetailsList;
    }

    public Poheader getPonumber() {
        return ponumber;
    }

    public void setPonumber(Poheader ponumber) {
        this.ponumber = ponumber;
    }

    public List<Integer> getSelectedLineItem()
	{
		return selectedLineItem;
	}

	public void setSelectedLineItem(List<Integer> selectedLineItem)
	{
		this.selectedLineItem = selectedLineItem;
	}

	public List<BigDecimal> getSelectedASNQty()
	{
		return selectedASNQty;
	}

	public void setSelectedASNQty(List<BigDecimal> selectedASNQty)
	{
		this.selectedASNQty = selectedASNQty;
	}

	public String getAsnCreateDateString()
	{
		return asnCreateDateString;
	}

	public void setAsnCreateDateString(String asnCreateDateString)
	{
		this.asnCreateDateString = asnCreateDateString;
	}

	public String getDeliveryDateString()
	{
		return deliveryDateString;
	}

	public void setDeliveryDateString(String deliveryDateString)
	{
		this.deliveryDateString = deliveryDateString;
	}

	public String getShippingDateString()
	{
		return shippingDateString;
	}

	public void setShippingDateString(String shippingDateString)
	{
		this.shippingDateString = shippingDateString;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (asnId != null ? asnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asnheader)) {
            return false;
        }
        Asnheader other = (Asnheader) object;
        if ((this.asnId == null && other.asnId != null) || (this.asnId != null && !this.asnId.equals(other.asnId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Asnheader [asnId=" + asnId + ", asnNo=" + asnNo + ", sapAsnNo=" + sapAsnNo + ", asnCreateDate="
				+ asnCreateDate + ", customerName=" + customerName + ", deliveryDate=" + deliveryDate
				+ ", modeOfTransport=" + modeOfTransport + ", shippingDate=" + shippingDate + ", asnStatus=" + asnStatus
				+ ", transportCode=" + transportCode + ", shippingAddress=" + shippingAddress + ", asndetailsList="
				+ asndetailsList + ", ponumber=" + ponumber + ", selectedLineItem=" + selectedLineItem
				+ ", selectedASNQty=" + selectedASNQty + ", asnCreateDateString=" + asnCreateDateString
				+ ", deliveryDateString=" + deliveryDateString + ", shippingDateString=" + shippingDateString + "]";
	}

   
    
}
