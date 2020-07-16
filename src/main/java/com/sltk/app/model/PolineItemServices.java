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
@Table(name = "poservicelineitem")
public class PolineItemServices implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
	@Column(name="service_id")
	private int serviceId;
	@Column(name="service_no")
	private String serviceNo;
	@Column(name="po_line_id")
	private String poLineId;
	@Column(name="service_line_no")
	private Long serviceLineNo;
	@Column(name="description")
	private String description;
	@Column(name="quantity")
	private BigDecimal quantity;
	@Column(name="uom")
	private String uom;
	@Column(name="gross_price")
	private BigDecimal grosPrice;
		
	
	@JoinColumn(name = "line_id", referencedColumnName = "line_id")
    @ManyToOne(optional = false)
	private Polineitems line_id;
	
	@JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
    @ManyToOne(optional = false)
    private Poheader ponumber;

	public PolineItemServices() {
		
	}
	public PolineItemServices(int serviceId) {
		this.serviceId= serviceId;
	}
	public PolineItemServices(String serviceId) {
		this.serviceId= Integer.parseInt(serviceId);
	}
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceNo() {
		return serviceNo;
	}
	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}
	public String getPoLineId() {
		return poLineId;
	}
	public void setPoLineId(String poLineId) {
		this.poLineId = poLineId;
	}
	public Long getServiceLineNo() {
		return serviceLineNo;
	}
	public void setServiceLineNo(Long serviceLineNo) {
		this.serviceLineNo = serviceLineNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public String getUom() {
		return uom;
	}
	public void setUom(String uom) {
		this.uom = uom;
	}
	public BigDecimal getGrosPrice() {
		return grosPrice;
	}
	public void setGrosPrice(BigDecimal grosPrice) {
		this.grosPrice = grosPrice;
	}
	
	public Polineitems getLine_id() {
		return line_id;
	}
	public void setLine_id(Polineitems line_id) {
		this.line_id = line_id;
	}
	public Poheader getPonumber() {
		return ponumber;
	}
	public void setPonumber(Poheader ponumber) {
		this.ponumber = ponumber;
	}
	
	
}
