package com.sltk.app.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.app.dao.AccountDao;
import com.sltk.app.model.Account;

@RestController
@RequestMapping("/plant")
public class AccountController {
	
	@Autowired
	private AccountDao accountDao;
	

	@RequestMapping(value = "/accountupload", method = RequestMethod.POST)
	public String savePurchaser(@Valid @RequestBody List<Account> account) throws IOException {
	
		FileInputStream file = new FileInputStream(new File("C:/Users/Desktop/data.csv")); 
		XSSFWorkbook workbook = new XSSFWorkbook(file); 
		XSSFSheet sheet = workbook.getSheetAt(1); 
	    Row row;
	    for(int i=1; i<=sheet.getLastRowNum(); i++){  //points to the starting of excel i.e excel first row
	        row = (Row) sheet.getRow(i);  //sheet number
	        
	        
	            String accountGroup;
				if( row.getCell(0)==null) { accountGroup = "null"; }
	            else accountGroup= row.getCell(0).toString();

	               String name;
				if( row.getCell(1)==null) { name = "null";}  //suppose excel cell is empty then its set to 0 the variable
	               else name = row.getCell(1).toString();   //else copies cell data to name variable

	             Account acc = new Account();
	    
	             acc.setAccountGroup(accountGroup);
	             acc.setName(name);
	   
	   System.out.println(acc.toString());
	  
	   accountDao.save(acc);


}
		return "account group added";
}
}