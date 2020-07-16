package com.sltk.app.entity.sap;

import java.io.Serializable;

public class PaymentDetailsSapEntity implements Serializable {

	 private static final long serialVersionUID = 1L;
	 
	private String invoice_ref_numbe;
	private String invoice_amount;
	private String amount_paid;
	private String due_amount;
	private String status;
	
	public PaymentDetailsSapEntity() {		
	}

	public PaymentDetailsSapEntity(String invoice_ref_numbe, String invoice_amount, String amount_paid,
			String due_amount, String status) {
		super();
		this.invoice_ref_numbe = invoice_ref_numbe;
		this.invoice_amount = invoice_amount;
		this.amount_paid = amount_paid;
		this.due_amount = due_amount;
		this.status = status;
	}

	public String getInvoice_ref_numbe() {
		return invoice_ref_numbe;
	}

	public void setInvoice_ref_numbe(String invoice_ref_numbe) {
		this.invoice_ref_numbe = invoice_ref_numbe;
	}

	public String getInvoice_amount() {
		return invoice_amount;
	}

	public void setInvoice_amount(String invoice_amount) {
		this.invoice_amount = invoice_amount;
	}

	public String getAmount_paid() {
		return amount_paid;
	}

	public void setAmount_paid(String amount_paid) {
		this.amount_paid = amount_paid;
	}

	public String getDue_amount() {
		return due_amount;
	}

	public void setDue_amount(String due_amount) {
		this.due_amount = due_amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
