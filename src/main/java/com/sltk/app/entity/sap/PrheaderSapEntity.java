package com.sltk.app.entity.sap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PrheaderSapEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private String pr_number;
	private String pr_description;
	
	private List<PrlineItemsSapEntity> prlineitemslist = new ArrayList<PrlineItemsSapEntity>();
	
	public PrheaderSapEntity() {
		
	}


	public String getPr_number() {
		return pr_number;
	}

	public void setPr_number(String pr_number) {
		this.pr_number = pr_number;
	}

	public String getPr_description() {
		return pr_description;
	}

	public void setPr_description(String pr_description) {
		this.pr_description = pr_description;
	}


	public List<PrlineItemsSapEntity> getPrlineitemslist() {
		return prlineitemslist;
	}


	public void setPrlineitemslist(List<PrlineItemsSapEntity> prlineitemslist) {
		this.prlineitemslist = prlineitemslist;
	}

	

	
}
