package com.sltk.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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
@Table(name = "prlineitems")
@NamedQueries({ @NamedQuery(name = "PrlineItems.findAll", query = "SELECT p FROM PrlineItems p"),
		@NamedQuery(name = "PrlineItems.findByPrId", query = "SELECT p FROM PrlineItems p WHERE p.prId = :prId"),
		@NamedQuery(name = "PrlineItems.findByPrLineId", query = "SELECT p FROM PrlineItems p WHERE p.prLineId = :prLineId"),
		@NamedQuery(name = "PrlineItems.findByDesciption", query = "SELECT p FROM PrlineItems p WHERE p.desciption = :desciption"),
		@NamedQuery(name = "PrlineItems.findByMeterialNumber", query = "SELECT p FROM PrlineItems p WHERE p.meterialNumber = :meterialNumber"),
		@NamedQuery(name = "PrlineItems.findByOrderQty", query = "SELECT p FROM PrlineItems p WHERE p.orderQty = :orderQty"),
		@NamedQuery(name = "PrlineItems.findByMeterialCatagory", query = "SELECT p FROM PrlineItems p WHERE p.meterialCatagory = :meterialCatagory"),
		@NamedQuery(name = "PrlineItems.findByUom", query = "SELECT p FROM PrlineItems p WHERE p.uom = :uom"),
		@NamedQuery(name = "PrlineItems.findByItemType", query = "SELECT p FROM PrlineItems p WHERE p.itemType = :itemType"),
		@NamedQuery(name = "PrlineItems.findByPlant", query = "SELECT p FROM PrlineItems p WHERE p.plant = :plant"),
		@NamedQuery(name = "PrlineItems.findByCreatedDate", query = "SELECT p FROM PrlineItems p WHERE p.createdDate = :createdDate"), })
public class PrlineItems implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "line_id")
	private Long prId;
	@Column(name = "pr_line_number")
	private String prLineId;
	@Column(name = "description")
	private String desciption;
	@Column(name = "materialnumber")
	private String meterialNumber;
	@Column(name = "materialcatagory")
	private String meterialCatagory;
	@Column(name = "orderquantity")
	private BigDecimal orderQty;
	@Column(name = "uom")
	private String uom;
	@Column(name = "itemtype")
	private String itemType;
	@Column(name = "plant")
	private String plant;
	@Column(name = "pr_created_date")
	private String createdDate;

	@JoinColumn(name = "pr_number", referencedColumnName = "pr_number")
	@ManyToOne(optional = false)
	private Prheader prnumber;

	public PrlineItems() {

	}

	public PrlineItems(Long prId) {
		this.prId = prId;
	}

	public PrlineItems(String prId) {
		this.prId = Long.parseLong(prId);
	}

	public Long getPrId() {
		return prId;
	}

	public void setPrId(Long prId) {
		this.prId = prId;
	}

	public String getPrLineId() {
		return prLineId;
	}

	public void setPrLineId(String prLineId) {
		this.prLineId = prLineId;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getMeterialNumber() {
		return meterialNumber;
	}

	public void setMeterialNumber(String meterialNumber) {
		this.meterialNumber = meterialNumber;
	}

	public String getMeterialCatagory() {
		return meterialCatagory;
	}

	public void setMeterialCatagory(String meterialCatagory) {
		this.meterialCatagory = meterialCatagory;
	}

	public BigDecimal getOrderQty() {
		return orderQty;
	}

	public void setOrderQty(BigDecimal orderQty) {
		this.orderQty = orderQty;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public Prheader getPrnumber() {
		return prnumber;
	}

	public void setPrnumber(Prheader prnumber) {
		this.prnumber = prnumber;
	}

}
