package com.sltk.app.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "paymentdetails")
@NamedQueries({
    @NamedQuery(name = "PaymentDetails.findAll", query = "SELECT p FROM PaymentDetails p"),
    @NamedQuery(name = "PaymentDetails.findByDetailId", query = "SELECT p FROM PaymentDetails p WHERE p.detailId = :detailId"),
    @NamedQuery(name = "PaymentDetails.findByInvoice_ref_number", query = "SELECT p FROM PaymentDetails p WHERE p.invoice_ref_number = :invoice_ref_number"),
    @NamedQuery(name = "PaymentDetails.findByInvoice_amount", query = "SELECT p FROM PaymentDetails p WHERE p.invoice_amount = :invoice_amount"),
    @NamedQuery(name = "PaymentDetails.findByAmount_paid", query = "SELECT p FROM PaymentDetails p WHERE p.amount_paid = :amount_paid"),
    @NamedQuery(name = "PaymentDetails.findByDue_amount", query = "SELECT p FROM PaymentDetails p WHERE p.due_amount = :due_amount"),
    @NamedQuery(name = "PaymentDetails.findByStatus", query = "SELECT p FROM PaymentDetails p WHERE p.status = :status"),
    })
public class PaymentDetails implements Serializable {

	 private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payment_id")
	private Long detailId;
	@Column(name="invoice_ref_number")
	private String invoice_ref_number;
	@Column(name="invoice_amount")
	private BigDecimal invoice_amount;
	@Column(name="amount_paid")
	private BigDecimal amount_paid;
	@Column(name="due_amount")
	private BigDecimal due_amount;
	@Column(name="status")
	private String status;

	@JoinColumn(name = "account_doc_number", referencedColumnName = "account_doc_number")
	@ManyToOne(optional = false)
	private PaymentHeader paymentDetail;

	public PaymentDetails() {
	}
	public PaymentDetails(Long detialId) {
		this.detailId=detialId;
	}
	public PaymentDetails(String detailId) {
		this.detailId=Long.parseLong(detailId);
	}
	public Long getDetailId() {
		return detailId;
	}
	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}
	public String getInvoice_ref_number() {
		return invoice_ref_number;
	}
	public void setInvoice_ref_number(String invoice_ref_number) {
		this.invoice_ref_number = invoice_ref_number;
	}
	public BigDecimal getInvoice_amount() {
		return invoice_amount;
	}
	public void setInvoice_amount(BigDecimal invoice_amount) {
		this.invoice_amount = invoice_amount;
	}
	public BigDecimal getAmount_paid() {
		return amount_paid;
	}
	public void setAmount_paid(BigDecimal amount_paid) {
		this.amount_paid = amount_paid;
	}
	public BigDecimal getDue_amount() {
		return due_amount;
	}
	public void setDue_amount(BigDecimal due_amount) {
		this.due_amount = due_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public PaymentHeader getPaymentDetail() {
		return paymentDetail;
	}
	public void setPaymentDetail(PaymentHeader paymentDetail) {
		this.paymentDetail = paymentDetail;
	}
	

}
