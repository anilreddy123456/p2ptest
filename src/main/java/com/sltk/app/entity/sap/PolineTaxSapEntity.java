package com.sltk.app.entity.sap;

import java.io.Serializable;

public class PolineTaxSapEntity implements Serializable {
	private String tax_description;
	private String tax_rate;
	private String ponumber;
	private String polineid;

	public PolineTaxSapEntity() {

	}

	public String getTax_description() {
		return tax_description;
	}

	public void setTax_description(String tax_description) {
		this.tax_description = tax_description;
	}

	public String getTax_rate() {
		return tax_rate;
	}

	public void setTax_rate(String tax_rate) {
		this.tax_rate = tax_rate;
	}

	public String getPonumber() {
		return ponumber;
	}

	public void setPonumber(String ponumber) {
		this.ponumber = ponumber;
	}

	public String getPolineid() {
		return polineid;
	}

	public void setPolineid(String polineid) {
		this.polineid = polineid;
	}

	@Override
	public String toString() {
		return "PolineTaxSapEntity [tax_description=" + tax_description + ", tax_rate=" + tax_rate + ", ponumber="
				+ ponumber + ", polineid=" + polineid + "]";
	}

}
