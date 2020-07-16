package com.sltk.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.app.dao.VendorDao;
import com.sltk.app.entity.sap.VendorSAPEntity;
import com.sltk.app.model.Vendor;


@RestController
@RequestMapping("/vendor")
public class VendorController {
	
	@Autowired
	private VendorDao v_dao;

	@RequestMapping("/rigistration")
	public String rigister(@Valid @RequestBody List<VendorSAPEntity> vendorSapEntity) {
		
		System.out.println(vendorSapEntity.toString());
		
		List<Vendor> vendorList=new ArrayList<Vendor>();
		
		for (VendorSAPEntity vendorsap : vendorSapEntity) {
			
			Vendor vendor= new Vendor();
			
			vendor.setVendorSapCode(vendorsap.getVendor_sap_code());
			vendor.setVendorCompanyName(vendorsap.getVendor_company_name());
			//vendor.setRigistrationNo(vendorsap.get);
			vendor.setCompanyType("SLTS");
			vendor.setAddressLine1(vendorsap.getAddress_line1());
			vendor.setAddressLine2(vendorsap.getAddress_line2());
			vendor.setCity(vendorsap.getCity());
			//vendor.setSalutation(vendorsap.getState());
			vendor.setState(vendorsap.getState());
			vendor.setPincode(vendorsap.getPincode());
			vendor.setCountry(vendorsap.getCountry());
			vendor.setGstNo(vendorsap.getGst_no());
			vendor.setPan(vendorsap.getPan());
			//vendor.setOther(vendorsap.getOther());
			//vendor.setSalutation(vendorsap.getSalutation());
			vendor.setFirstName(vendorsap.getFirst_name());
			vendor.setLastName(vendorsap.getLast_name());
			vendor.setUserName(vendorsap.getVendor_sap_code()); //vedor sapcode is the user name here for imported vendors
			vendor.setPhoneNo(vendorsap.getPhone_no());
			vendor.setMobileNo(vendorsap.getMobile_no());
			vendor.setEmailId(vendorsap.getEmail_id());
			vendor.setAccHolderName(vendorsap.getAcc_holder_name());
			vendor.setAccountNo(vendorsap.getAccount_no());
			vendor.setBankName(vendorsap.getBank_name());
			vendor.setBranchName(vendorsap.getBranch_name());
			vendor.setIfscCode(vendorsap.getIfsc_code());
			vendor.setBankCountry(vendorsap.getBank_country());
			vendor.setBankRegion(vendorsap.getBank_region());
			vendor.setBankCity(vendorsap.getBank_city());
			//vendor.setProductionServices(vendorsap.getp);
			vendor.setFax(vendorsap.getFax());
			vendor.setAltFax(vendorsap.getAlt_fax());
			vendor.setAltFirstName(vendorsap.getAlt_first_name());
			vendor.setAltLastName(vendorsap.getAlt_last_name());
			vendor.setPhoneNo(vendorsap.getAlt_phone_no());
			vendor.setAltMobileNo(vendorsap.getAlt_mobile_no());
			vendor.setAltEmailId(vendorsap.getAlt_email_id());
			//vendor.setStatus(vendorsap.gets);
			
			vendorList.add(vendor);
		}
		
		
		v_dao.saveAll(vendorList);
		
		System.out.println(vendorSapEntity.toString());
		
		return "Rigistration sucessfully ";
		
		}
}
