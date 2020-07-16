package com.sltk.app.entity.sap;

import java.io.Serializable;

public class PrlineItemsSapEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String pr_number;
	private String pr_line_number;
	private String description;
	private String materialnumber;
	private String materialcatagory;
	private String orderquantity;
	private String uom;
	private String itemtype;
	private String plant;
	private String pr_created_date;
	
	public PrlineItemsSapEntity() {
		
	}

	public PrlineItemsSapEntity(String pr_number, String pr_line_number, String description, String materialnumber,
			String materialcatagory, String orderquantity, String uom, String netvalue, String itemtype, String plant,
			String pr_created_date) {
		super();
		this.pr_number = pr_number;
		this.pr_line_number = pr_line_number;
		this.description = description;
		this.materialnumber = materialnumber;
		this.materialcatagory = materialcatagory;
		this.orderquantity = orderquantity;
		this.uom = uom;
		this.itemtype = itemtype;
		this.plant = plant;
		this.pr_created_date = pr_created_date;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaterialnumber() {
		return materialnumber;
	}

	public void setMaterialnumber(String materialnumber) {
		this.materialnumber = materialnumber;
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

	public String getItemtype() {
		return itemtype;
	}

	public void setItemtype(String itemtype) {
		this.itemtype = itemtype;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getPr_created_date() {
		return pr_created_date;
	}

	public void setPr_created_date(String pr_created_date) {
		this.pr_created_date = pr_created_date;
	}
	
}
