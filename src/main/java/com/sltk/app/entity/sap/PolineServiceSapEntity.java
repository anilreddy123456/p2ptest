package com.sltk.app.entity.sap;

import java.io.Serializable;

public class PolineServiceSapEntity implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private String ponumber;
	private String po_line_id;
	private String service_no;
	private String service_line_no;
	private String description;
	private String quantity;
	private String uom;
	private String gross_price;
	
	
	public PolineServiceSapEntity() {
		
	}

	public String getPonumber() {
		return ponumber;
	}

	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}

	public String getPo_line_id() {
		return po_line_id;
	}

	public void setPo_line_id(String po_line_id) {
		this.po_line_id = po_line_id;
	}

	public String getService_no() {
		return service_no;
	}

	public void setService_no(String service_no) {
		this.service_no = service_no;
	}

	public String getService_line_no() {
		return service_line_no;
	}

	public void setService_line_no(String service_line_no) {
		this.service_line_no = service_line_no;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getGross_price() {
		return gross_price;
	}

	public void setGross_price(String gross_price) {
		this.gross_price = gross_price;
	}

	
	
}
