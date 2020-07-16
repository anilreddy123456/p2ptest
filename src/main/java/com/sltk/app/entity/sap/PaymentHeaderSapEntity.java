package com.sltk.app.entity.sap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaymentHeaderSapEntity implements Serializable {

	 private static final long serialVersionUID = 1L;
	private String account_doc_number;
	private String postingdate;
	private String curruency;
	private String companycode;
	private String  fiscalyear;
	private String gross_value;
	private String discount;
	private String net_value;
	
	private List<PaymentDetailsSapEntity> paymentdetailslist = new ArrayList<PaymentDetailsSapEntity>();
	
	public PaymentHeaderSapEntity() {
		
	}

	public PaymentHeaderSapEntity(String account_doc_number, String postingdate, String curruency, String companycode,
			String fiscalyear, String gross_value, String discount, String net_value,
			List<PaymentDetailsSapEntity> paymentdetailslist) {
		super();
		this.account_doc_number = account_doc_number;
		this.postingdate = postingdate;
		this.curruency = curruency;
		this.companycode = companycode;
		this.fiscalyear = fiscalyear;
		this.gross_value = gross_value;
		this.discount = discount;
		this.net_value = net_value;
		this.paymentdetailslist = paymentdetailslist;
	}

	public String getAccount_doc_number() {
		return account_doc_number;
	}

	public void setAccount_doc_number(String account_doc_number) {
		this.account_doc_number = account_doc_number;
	}

	public String getPostingdate() {
		return postingdate;
	}

	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}

	public String getCurruency() {
		return curruency;
	}

	public void setCurruency(String curruency) {
		this.curruency = curruency;
	}

	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public String getFiscalyear() {
		return fiscalyear;
	}

	public void setFiscalyear(String fiscalyear) {
		this.fiscalyear = fiscalyear;
	}

	public String getGross_value() {
		return gross_value;
	}

	public void setGross_value(String gross_value) {
		this.gross_value = gross_value;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getNet_value() {
		return net_value;
	}

	public void setNet_value(String net_value) {
		this.net_value = net_value;
	}

	public List<PaymentDetailsSapEntity> getPaymentdetailslist() {
		return paymentdetailslist;
	}

	public void setPaymentdetailslist(List<PaymentDetailsSapEntity> paymentdetailslist) {
		this.paymentdetailslist = paymentdetailslist;
	}

	@Override
	public String toString() {
		return "PaymentHeaderSapEntity [account_doc_number=" + account_doc_number + ", postingdate=" + postingdate
				+ ", curruency=" + curruency + ", companycode=" + companycode + ", fiscalyear=" + fiscalyear
				+ ", gross_value=" + gross_value + ", discount=" + discount + ", net_value=" + net_value
				+ ", paymentdetailslist=" + paymentdetailslist + "]";
	}
	
}
