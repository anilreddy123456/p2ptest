package com.sltk.app.entity.sap;

import java.util.ArrayList;
import java.util.List;

/********************************************************************
* @Class Name         : InvoiceSapEntity.java                                                                
*                                                                                                                                        
* @author             : Dheeraj Singh                                                                
* @version            :                                                                        
* @Creation Date      : 21-Jan-2020                                                                
* @Last Modified By   : Dheeraj Singh                                                                
* @Last Modified Date : 21-Jan-2020                                                                                
*********************************************************************
*    
*********************************************************************
*/
public class InvoiceSapEntity
{
	private String ponumber;
	private String invdate;
	private String postingdate;
	private String refdocno;
	private String compid;
	private String currency;
	private String totalinvamount;
	private List<InvoiceDetailSapEntity> itemdata = new ArrayList<InvoiceDetailSapEntity>();
	
	public InvoiceSapEntity()
	{
	}

	public InvoiceSapEntity(String ponumber, String invdate, String postingdate, String refdocno, String compid, String currency, String totalinvamount)
	{
		this.ponumber = ponumber;
		this.invdate = invdate;
		this.postingdate = postingdate;
		this.refdocno = refdocno;
		this.compid = compid;
		this.currency = currency;
		this.totalinvamount = totalinvamount;
	}

	public String getPonumber()
	{
		return ponumber;
	}

	public void setPonumber(String ponumber)
	{
		this.ponumber = ponumber;
	}

	public String getInvdate()
	{
		return invdate;
	}

	public void setInvdate(String invdate)
	{
		this.invdate = invdate;
	}

	public String getPostingdate()
	{
		return postingdate;
	}

	public void setPostingdate(String postingdate)
	{
		this.postingdate = postingdate;
	}

	public String getRefdocno()
	{
		return refdocno;
	}

	public void setRefdocno(String refdocno)
	{
		this.refdocno = refdocno;
	}

	public String getCompid()
	{
		return compid;
	}

	public void setCompid(String compid)
	{
		this.compid = compid;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public String getTotalinvamount()
	{
		return totalinvamount;
	}

	public void setTotalinvamount(String totalinvamount)
	{
		this.totalinvamount = totalinvamount;
	}

	public List<InvoiceDetailSapEntity> getItemdata()
	{
		return itemdata;
	}

	public void setItemdata(List<InvoiceDetailSapEntity> itemdata)
	{
		this.itemdata = itemdata;
	}
	
}
