/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sltk.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

/**
 *
 * @author DheerajSingh
 */
@Entity
@Table(name = "polineitems")
@NamedQueries({
    @NamedQuery(name = "Polineitems.findAll", query = "SELECT p FROM Polineitems p"),
    @NamedQuery(name = "Polineitems.findByLineId", query = "SELECT p FROM Polineitems p WHERE p.lineId = :lineId"),
    @NamedQuery(name = "Polineitems.findByAsnStatus", query = "SELECT p FROM Polineitems p WHERE p.asnStatus = :asnStatus"),
    @NamedQuery(name = "Polineitems.findByPoLineId", query = "SELECT p FROM Polineitems p WHERE p.poLineId = :poLineId"),
    @NamedQuery(name = "Polineitems.findByItemType", query = "SELECT p FROM Polineitems p WHERE p.itemType = :itemType"),
    @NamedQuery(name = "Polineitems.findByDeliveryDate", query = "SELECT p FROM Polineitems p WHERE p.deliveryDate = :deliveryDate"),
    @NamedQuery(name = "Polineitems.findByMaterialNumber", query = "SELECT p FROM Polineitems p WHERE p.materialNumber = :materialNumber"),
    @NamedQuery(name = "Polineitems.findByDescription", query = "SELECT p FROM Polineitems p WHERE p.description = :description"),
    @NamedQuery(name = "Polineitems.findByPlant", query = "SELECT p FROM Polineitems p WHERE p.plant = :plant"),
    @NamedQuery(name = "Polineitems.findByMaterialCatagory", query = "SELECT p FROM Polineitems p WHERE p.materialCatagory = :materialCatagory"),
    @NamedQuery(name = "Polineitems.findByOrderQuantity", query = "SELECT p FROM Polineitems p WHERE p.orderQuantity = :orderQuantity"),
    @NamedQuery(name = "Polineitems.findByUom", query = "SELECT p FROM Polineitems p WHERE p.uom = :uom"),
    @NamedQuery(name = "Polineitems.findByGrossValue", query = "SELECT p FROM Polineitems p WHERE p.grossValue = :grossValue"),
    @NamedQuery(name = "Polineitems.findByNetValue", query = "SELECT p FROM Polineitems p WHERE p.netValue = :netValue"),
    @NamedQuery(name = "Polineitems.findByBalanceAsnQty", query = "SELECT p FROM Polineitems p WHERE p.balanceAsnQty = :balanceAsnQty"),
    @NamedQuery(name = "Polineitems.findByPreviousAsnQty", query = "SELECT p FROM Polineitems p WHERE p.previousAsnQty = :previousAsnQty"),
    @NamedQuery(name = "Polineitems.findByPrLineNo", query = "SELECT p FROM Polineitems p WHERE p.prLineNo = :prLineNo")})
public class Polineitems implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "line_id")
    private Integer lineId;
    
    @Size(max = 2)
    @Column(name = "asn_status")
    private String asnStatus;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "po_line_id")
    private int poLineId;
    
    @Size(max = 200)
    @Column(name = "item_type")
    private String itemType;
    
    @Column(name = "deliverydate")
    private String deliveryDate;
    
    @Size(max = 200)
    @Column(name = "material_number")
    private String materialNumber;
    
    @Size(max = 250)
    @Column(name = "description")
    private String description;
    
    @Size(max = 10)
    @Column(name = "plant")
    private String plant;
    
    @Size(max = 200)
    @Column(name = "material_catagory")
    private String materialCatagory;
    
    @Column(name = "order_quantity")
    private BigDecimal orderQuantity;
    
    @Size(max = 100)
    @Column(name = "uom")
    private String uom;
    
    @Column(name = "sap_tax_code")
    private String sapTaxCode;
    

    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gross_value")
    private BigDecimal grossValue;

    @Column(name = "net_value")
    private BigDecimal netValue;

    @Column(name = "balance_asn_qty")
    private BigDecimal balanceAsnQty;
  
    @Column(name = "previous_asn_qty")
    private BigDecimal previousAsnQty;
    
    @Column(name = "pr_line_number")
    private Integer prLineNo;
    /*
    @Column(name = "pr_number")
    private String prNumber;
    */
    @JoinColumn(name = "pr_number", referencedColumnName = "pr_number")
    @ManyToOne(optional = false)
    private Prheader pr_number;
    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "line_id")
    private List<PolineItemTaxes> polineItemTaxes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "line_id")
    private List<PolineItemServices> polineItemServices;
    
    @JoinColumn(name = "ponumber", referencedColumnName = "ponumber")
    @ManyToOne(optional = false)
    private Poheader ponumber;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lineId")
    private List<Grndetails> grndetailsList;

    public Polineitems() {
    }

    public Polineitems(Integer lineId) {
        this.lineId = lineId;
    }
    public Polineitems(String lineId) {
        this.lineId = Integer.parseInt(lineId);
    }

    public Polineitems(Integer lineId, int poLineId) {
        this.lineId = lineId;
        this.poLineId = poLineId;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public String getAsnStatus() {
        return asnStatus;
    }

    public void setAsnStatus(String asnStatus) {
        this.asnStatus = asnStatus;
    }

    public int getPoLineId() {
        return poLineId;
    }

    public void setPoLineId(int poLineId) {
        this.poLineId = poLineId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getMaterialCatagory() {
        return materialCatagory;
    }

    public void setMaterialCatagory(String materialCatagory) {
        this.materialCatagory = materialCatagory;
    }

    public BigDecimal getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(BigDecimal orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getSapTaxCode()
	{
		return sapTaxCode;
	}

	public void setSapTaxCode(String sapTaxCode)
	{
		this.sapTaxCode = sapTaxCode;
	}

	public BigDecimal getGrossValue() {
        return grossValue;
    }

    public void setGrossValue(BigDecimal grossValue) {
        this.grossValue = grossValue;
    }

    public BigDecimal getNetValue() {
        return netValue;
    }

    public void setNetValue(BigDecimal netValue) {
        this.netValue = netValue;
    }

    public BigDecimal getBalanceAsnQty() {
        return balanceAsnQty;
    }

    public void setBalanceAsnQty(BigDecimal balanceAsnQty) {
        this.balanceAsnQty = balanceAsnQty;
    }

    public BigDecimal getPreviousAsnQty() {
        return previousAsnQty;
    }

    public void setPreviousAsnQty(BigDecimal previousAsnQty) {
        this.previousAsnQty = previousAsnQty;
    }
    
   /*
	public String getPrNumber() {
		return prNumber;
	}

	public void setPrNumber(String prNumber) {
		this.prNumber = prNumber;
	}
*/

    public Integer getPrLineNo() {
		return prLineNo;
	}

	public void setPrLineNo(Integer prLineNo) {
		this.prLineNo = prLineNo;
	}

	public Prheader getPr_number() {
		return pr_number;
	}

	public Poheader getPonumber() {
		return ponumber;
	}

	public void setPonumber(Poheader ponumber) {
		this.ponumber = ponumber;
	}

	public void setPr_number(Prheader pr_number) {
		this.pr_number = pr_number;
	}


	public List<Grndetails> getGrndetailsList()
	{
		return grndetailsList;
	}

	public void setGrndetailsList(List<Grndetails> grndetailsList)
	{
		this.grndetailsList = grndetailsList;
	}
	

	public List<PolineItemTaxes> getPolineItemTaxes() {
		return polineItemTaxes;
	}

	public void setPolineItemTaxes(List<PolineItemTaxes> polineItemTaxes) {
		this.polineItemTaxes = polineItemTaxes;
	}
	

	public List<PolineItemServices> getPolineItemServices() {
		return polineItemServices;
	}

	public void setPolineItemServices(List<PolineItemServices> polineItemServices) {
		this.polineItemServices = polineItemServices;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (lineId != null ? lineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Polineitems)) {
            return false;
        }
        Polineitems other = (Polineitems) object;
        if ((this.lineId == null && other.lineId != null) || (this.lineId != null && !this.lineId.equals(other.lineId))) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Polineitems [lineId=" + lineId + ", asnStatus=" + asnStatus + ", poLineId=" + poLineId + ", itemType="
				+ itemType + ", materialNumber=" + materialNumber + ", description=" + description + ", plant=" + plant
				+ ", materialCatagory=" + materialCatagory + ", orderQuantity=" + orderQuantity + ", uom=" + uom
				+ ", sapTaxCode=" + sapTaxCode + ", grossValue=" + grossValue + ", netValue=" + netValue
				+ ", balanceAsnQty=" + balanceAsnQty + ", previousAsnQty=" + previousAsnQty + ", pr_number=" + pr_number
				+ ", polineItemTaxes=" + polineItemTaxes + ", polineItemServices=" + polineItemServices + ", ponumber="
				+ ponumber + ", grndetailsList=" + grndetailsList + "]";
	}

	   

	/*
	 * @Override public String toString() { return
	 * "com.sltk.app.entity.Polineitems[ lineId=" + lineId + " ]"; }
	 */
    
}
