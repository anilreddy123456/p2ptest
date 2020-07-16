package com.sltk.app.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.app.dao.PaymentDao;
import com.sltk.app.entity.sap.PaymentDetailsSapEntity;
import com.sltk.app.entity.sap.PaymentHeaderSapEntity;
import com.sltk.app.model.PaymentDetails;
import com.sltk.app.model.PaymentHeader;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentDao paymentDao;

	@RequestMapping(value = "/save/payment", method = RequestMethod.POST)
	public String createPayments(@Valid @RequestBody List<PaymentHeaderSapEntity> payment) {
		System.out.println(payment.toString());
		List<PaymentHeader> paymentHeadersList = new ArrayList<PaymentHeader>();
		for (PaymentHeaderSapEntity paymentHeaderSapEntity : payment) {
			PaymentHeader paymentHeader = new PaymentHeader();

			paymentHeader.setAccountDocNnumber(Long.parseLong(paymentHeaderSapEntity.getAccount_doc_number()));
			paymentHeader.setCompanyCode(paymentHeaderSapEntity.getCompanycode());
			paymentHeader.setPostingDate(paymentHeaderSapEntity.getPostingdate());
			paymentHeader.setCurrency(paymentHeaderSapEntity.getCurruency());
			if(paymentHeaderSapEntity.getDiscount()==null) {
				paymentHeader.setDiscount(new BigDecimal(0.00));
			}else {
			paymentHeader.setDiscount(new BigDecimal(paymentHeaderSapEntity.getDiscount()));
			}
			paymentHeader.setFiscalYear(paymentHeaderSapEntity.getFiscalyear());
			paymentHeader.setGrossValue(new BigDecimal(paymentHeaderSapEntity.getGross_value()));
			paymentHeader.setNetValue(new BigDecimal(paymentHeaderSapEntity.getNet_value()));

			List<PaymentDetailsSapEntity> detailsSapEntities = paymentHeaderSapEntity.getPaymentdetailslist();
			List<PaymentDetails> paymentDetailsList = new ArrayList<PaymentDetails>();

			for (PaymentDetailsSapEntity PaymentDetailsSapEntity : detailsSapEntities) {

				PaymentDetails paymentDetails = new PaymentDetails();
				paymentDetails.setPaymentDetail(paymentHeader);
				paymentDetails.setInvoice_ref_number(PaymentDetailsSapEntity.getInvoice_ref_numbe());
				paymentDetails.setInvoice_amount(new BigDecimal(PaymentDetailsSapEntity.getInvoice_amount()));
				paymentDetails.setAmount_paid(new BigDecimal(PaymentDetailsSapEntity.getAmount_paid()));
				if (PaymentDetailsSapEntity.getDue_amount() == null) {
					paymentDetails.setDue_amount(new BigDecimal(0.00));
				} else {
					paymentDetails.setDue_amount(new BigDecimal(PaymentDetailsSapEntity.getDue_amount()));
				}
				paymentDetails.setStatus(PaymentDetailsSapEntity.getStatus());

				paymentDetailsList.add(paymentDetails);
			}
			paymentHeader.setPaymentDetails(paymentDetailsList);
			paymentHeadersList.add(paymentHeader);
		}
		System.out.println(paymentHeadersList.toString());
		paymentDao.saveAll(paymentHeadersList);
		System.out.println(paymentHeadersList.toString());
		return "payment created";
	}
}
