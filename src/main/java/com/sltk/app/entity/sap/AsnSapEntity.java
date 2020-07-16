package com.sltk.app.entity.sap;
/********************************************************************
* @Class Name         : AsnSapEntity.java                                                                
*                                                                                                                                        
* @author             : Dheeraj Singh                                                                
* @version            :                                                                        
* @Creation Date      : 04-Jan-2020                                                                
* @Last Modified By   : Dheeraj Singh                                                                
* @Last Modified Date : 04-Jan-2020                                                                                
*********************************************************************
*    
*********************************************************************
*/
public class AsnSapEntity
{
	private String vendorsapcode;
	private String ponumber;
	private String deliverydate;
	private String documentdate;
	private String externalid;
	private String meansoftransport;
	private String transportid;
	private String polineid;
	private String orderquantity;
	
	public AsnSapEntity()
	{
		
	}
	
	public AsnSapEntity(String vendorsapcode, String ponumber, String deliverydate, String documentdate, String externalid, String meansoftransport, String transportid, String polineid, String orderquantity)
	{
		this.vendorsapcode = vendorsapcode;
		this.ponumber = ponumber;
		this.deliverydate = deliverydate;
		this.documentdate = documentdate;
		this.externalid = externalid;
		this.meansoftransport = meansoftransport;
		this.transportid = transportid;
		this.polineid = polineid;
		this.orderquantity = orderquantity;
	}

	public String getVendorsapcode()
	{
		return vendorsapcode;
	}

	public void setVendorsapcode(String vendorsapcode)
	{
		this.vendorsapcode = vendorsapcode;
	}

	public String getPonumber()
	{
		return ponumber;
	}

	public void setPonumber(String ponumber)
	{
		this.ponumber = ponumber;
	}

	public String getDeliverydate()
	{
		return deliverydate;
	}

	public void setDeliverydate(String deliverydate)
	{
		this.deliverydate = deliverydate;
	}

	public String getDocumentdate()
	{
		return documentdate;
	}

	public void setDocumentdate(String documentdate)
	{
		this.documentdate = documentdate;
	}

	public String getExternalid()
	{
		return externalid;
	}

	public void setExternalid(String externalid)
	{
		this.externalid = externalid;
	}

	public String getMeansoftransport()
	{
		return meansoftransport;
	}

	public void setMeansoftransport(String meansoftransport)
	{
		this.meansoftransport = meansoftransport;
	}

	public String getTransportid()
	{
		return transportid;
	}

	public void setTransportid(String transportid)
	{
		this.transportid = transportid;
	}

	public String getPolineid()
	{
		return polineid;
	}

	public void setPolineid(String polineid)
	{
		this.polineid = polineid;
	}

	public String getOrderquantity()
	{
		return orderquantity;
	}

	public void setOrderquantity(String orderquantity)
	{
		this.orderquantity = orderquantity;
	}
	
}
