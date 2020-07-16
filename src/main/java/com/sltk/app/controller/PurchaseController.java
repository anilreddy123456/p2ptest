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

import com.sltk.app.dao.PurchaserDao;
import com.sltk.app.model.Plant;
import com.sltk.app.model.Purchaser;

@RestController
@RequestMapping("/plant")
public class PurchaseController {
	
	@Autowired
	private PurchaserDao dao;
	
	@RequestMapping(value = "/purchaseupload", method = RequestMethod.POST)
	public String savePurchaser(@Valid @RequestBody List<Purchaser> purchaser) throws IOException {
	

	FileInputStream file = new FileInputStream(new File("C:/Users/Desktop/data.csv")); 
	XSSFWorkbook workbook = new XSSFWorkbook(file); 
	XSSFSheet sheet = workbook.getSheetAt(1); 
    Row row;
    for(int i=1; i<=sheet.getLastRowNum(); i++){  //points to the starting of excel i.e excel first row
        row = (Row) sheet.getRow(i);  //sheet number
        
        
            String purchasingOrg;
			if( row.getCell(0)==null) { purchasingOrg = "null"; }
            else purchasingOrg= row.getCell(0).toString();

               String purchaseOrgDescr;
			if( row.getCell(1)==null) { purchaseOrgDescr = "null";}  //suppose excel cell is empty then its set to 0 the variable
               else purchaseOrgDescr = row.getCell(1).toString();   //else copies cell data to name variable

             Purchaser purchase = new Purchaser();
    
             purchase.setPurchaseOrgDescr(purchaseOrgDescr);
             purchase.setPurchasingOrg(purchasingOrg);
   
   System.out.println(purchase.toString());
  
   dao.save(purchase);
}
	return "plant values saved";

	}
	

}
