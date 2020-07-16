package com.sltk.app.entity.sap;
/********************************************************************
* @Class Name         : InvoiceDetailSapEntity.java                                                                
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
public class InvoiceDetailSapEntity
{
	private String invdocitem;
	private String ponumber;
	private String polineid;
	private String grnnumber;
	private String refdocyear;
	private String grnitemid;
	private String invamount;
	private String quantity;
	private String tax_code;
	private String uom;
	
	public InvoiceDetailSapEntity()
	{
	}
	
	public InvoiceDetailSapEntity(String invdocitem, String ponumber, String polineid, String grnnumber, String refdocyear, String grnitemid, String invamount, String quantity, String tax_code, String uom)
	{
		this.invdocitem = invdocitem;
		this.ponumber = ponumber;
		this.polineid = polineid;
		this.grnnumber = grnnumber;
		this.refdocyear = refdocyear;
		this.grnitemid = grnitemid;
		this.invamount = invamount;
		this.quantity = quantity;
		this.tax_code = tax_code;
		this.uom = uom;
	}

	public String getInvdocitem()
	{
		return invdocitem;
	}

	public void setInvdocitem(String invdocitem)
	{
		this.invdocitem = invdocitem;
	}

	public String getPonumber()
	{
		return ponumber;
	}

	public void setPonumber(String ponumber)
	{
		this.ponumber = ponumber;
	}

	public String getPolineid()
	{
		return polineid;
	}

	public void setPolineid(String polineid)
	{
		this.polineid = polineid;
	}

	public String getGrnnumber()
	{
		return grnnumber;
	}

	public void setGrnnumber(String grnnumber)
	{
		this.grnnumber = grnnumber;
	}

	public String getRefdocyear()
	{
		return refdocyear;
	}

	public void setRefdocyear(String refdocyear)
	{
		this.refdocyear = refdocyear;
	}

	public String getGrnitemid()
	{
		return grnitemid;
	}

	public void setGrnitemid(String grnitemid)
	{
		this.grnitemid = grnitemid;
	}

	public String getInvamount()
	{
		return invamount;
	}

	public void setInvamount(String invamount)
	{
		this.invamount = invamount;
	}

	public String getQuantity()
	{
		return quantity;
	}

	public void setQuantity(String quantity)
	{
		this.quantity = quantity;
	}

	public String getTax_code()
	{
		return tax_code;
	}

	public void setTax_code(String tax_code)
	{
		this.tax_code = tax_code;
	}

	public String getUom()
	{
		return uom;
	}

	public void setUom(String uom)
	{
		this.uom = uom;
	}
	
}
