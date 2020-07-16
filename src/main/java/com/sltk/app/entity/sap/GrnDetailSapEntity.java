package com.sltk.app.entity.sap;

import java.io.Serializable;

public class GrnDetailSapEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String grnnumber;
	private String ponumber;
	// private String lineid;
	private String po_line_id;
	private String grn_item_id;
	private String plant;
	private String quantity;
	private String grnmovementtype;
	private String matshortdesc;

	public GrnDetailSapEntity(String grnnumber, String ponumber, String polineid, String grn_item_id, String plant,
			String quantity, String grnmovementtype, String matshortdesc, String po_line_id) {
		super();
		this.grnnumber = grnnumber;
		this.ponumber = ponumber;
		// this.lineid = lineid;
		this.po_line_id = po_line_id;
		this.grn_item_id = grn_item_id;
		this.plant = plant;
		this.quantity = quantity;
		this.grnmovementtype = grnmovementtype;
		this.matshortdesc = matshortdesc;
	}

	public String getGrnnumber() {
		return grnnumber;
	}

	public void setGrnnumber(String grnnumber) {
		this.grnnumber = grnnumber;
	}

	/**
	 * public String getLineid() { return lineid; }
	 * 
	 * public void setLineid(String lineid) { this.lineid = lineid; }
	 **/

	public String getPo_line_id() {
		return po_line_id;
	}

	public String getPonumber() {
		return ponumber;
	}

	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}

	public void setPo_line_id(String po_line_id) {
		this.po_line_id = po_line_id;
	}

	public String getGrn_item_id() {
		return grn_item_id;
	}

	public void setGrn_item_id(String grn_item_id) {
		this.grn_item_id = grn_item_id;
	}

	public String getPlant() {
		return plant;
	}

	public void setPlant(String plant) {
		this.plant = plant;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getGrnmovementtype() {
		return grnmovementtype;
	}

	public void setGrnmovementtype(String grnmovementtype) {
		this.grnmovementtype = grnmovementtype;
	}

	public String getMatshortdesc() {
		return matshortdesc;
	}

	public void setMatshortdesc(String matshortdesc) {
		this.matshortdesc = matshortdesc;
	}

	@Override
	public String toString() {
		return "GrnDetailSapEntity [grnnumber=" + grnnumber + ", ponumber=" + ponumber + ", po_line_id=" + po_line_id
				+ ", grn_item_id=" + grn_item_id + ", plant=" + plant + ", quantity=" + quantity + ", grnmovementtype="
				+ grnmovementtype + ", matshortdesc=" + matshortdesc + "]";
	}

	

}
