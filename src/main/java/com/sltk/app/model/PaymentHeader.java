package com.sltk.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="paymentheader")
@NamedQueries({
    @NamedQuery(name = "PaymentHeader.findAll", query = "SELECT p FROM PaymentHeader p"),
    @NamedQuery(name = "PaymentHeader.findByAccountDocNnumber", query = "SELECT p FROM PaymentHeader p WHERE p.accountDocNnumber = :accountDocNnumber"),
    @NamedQuery(name = "PaymentHeader.findByPostingDate", query = "SELECT p FROM PaymentHeader p WHERE p.postingDate = :postingDate"),
    @NamedQuery(name = "PaymentHeader.findByCurrency", query = "SELECT p FROM PaymentHeader p WHERE p.currency = :currency"),
    @NamedQuery(name = "PaymentHeader.findByCompanyCode", query = "SELECT p FROM PaymentHeader p WHERE p.companyCode = :companyCode"),
    @NamedQuery(name = "PaymentHeader.findByFiscalYear", query = "SELECT p FROM PaymentHeader p WHERE p.fiscalYear = :fiscalYear"),
    @NamedQuery(name = "PaymentHeader.findByNetValue", query = "SELECT p FROM PaymentHeader p WHERE p.netValue = :netValue"),
    @NamedQuery(name = "PaymentHeader.findByGrossValue", query = "SELECT p FROM PaymentHeader p WHERE p.grossValue = :grossValue"),
    @NamedQuery(name = "PaymentHeader.findByDiscount", query = "SELECT p FROM PaymentHeader p WHERE p.discount = :discount")
    })
public class PaymentHeader implements Serializable {


	 private static final long serialVersionUID = 1L;
	@Id
    @Basic(optional = false)
    @NotNull
    @Column(name="account_doc_number")
	private Long accountDocNnumber;
    @Column(name="postingdate")
	private String postingDate;
    @Column(name="curruency")
	private String currency;
    @Column(name="companycode")
	private String companyCode;
    @Column(name="fiscalyear")
	private String  fiscalYear;
    @Column(name="gross_value")
	private BigDecimal grossValue;
    @Column(name="discount")
	private BigDecimal discount;
    @Column(name="net_value")
	private BigDecimal netValue;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentDetail")
    private List<PaymentDetails> paymentDetails;
	
	public PaymentHeader() {
		
	}
	public PaymentHeader(Long accountDocNnumber) {
		this.accountDocNnumber=accountDocNnumber;
	}
	public PaymentHeader(String accountDocNnumber) {
		this.accountDocNnumber=Long.parseLong(accountDocNnumber);
	}
	
	public Long getAccountDocNnumber() {
		return accountDocNnumber;
	}
	public void setAccountDocNnumber(Long accountDocNnumber) {
		this.accountDocNnumber = accountDocNnumber;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(String fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public BigDecimal getGrossValue() {
		return grossValue;
	}
	public void setGrossValue(BigDecimal grossValue) {
		this.grossValue = grossValue;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public BigDecimal getNetValue() {
		return netValue;
	}
	public void setNetValue(BigDecimal netValue) {
		this.netValue = netValue;
	}
	public List<PaymentDetails> getPaymentDetails() {
		return paymentDetails;
	}
	public void setPaymentDetails(List<PaymentDetails> paymentDetails) {
		this.paymentDetails = paymentDetails;
	}
	@Override
	public String toString() {
		return "PaymentHeader [accountDocNnumber=" + accountDocNnumber + ", postingDate=" + postingDate + ", currency="
				+ currency + ", companyCode=" + companyCode + ", fiscalYear=" + fiscalYear + ", grossValue="
				+ grossValue + ", discount=" + discount + ", netValue=" + netValue + ", paymentDetails="
				+ paymentDetails + "]";
	}
	
}
