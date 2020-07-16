package com.sltk.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.app.dao.CompanyDao;
import com.sltk.app.entity.sap.CompanySapEntity;
import com.sltk.app.model.Company;


// This is for vendor replication 

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyDao companyDao;
	
	@RequestMapping(value="/save/replcation",method = RequestMethod.POST)
	public String companyReplicationSave(@Valid @RequestBody List<CompanySapEntity> company) {
		
		List<Company> companyList= new ArrayList<Company>();
		
		for (CompanySapEntity company2 : company) {
			
			Company companyEntity= new Company();
			
			companyEntity.setCompCode(company2.getCompany_code());
			companyEntity.setCompName(company2.getVendor_company_name());
			companyEntity.setPurchaseOrg(company2.getPurchase_org());
			companyEntity.setAccountGroup(company2.getAccount_group());
			companyEntity.setCompRegNo("1326549");
			//companyEntity.setCompType(company2.getCompa);
			
			
		}
		return "";
	}
}
