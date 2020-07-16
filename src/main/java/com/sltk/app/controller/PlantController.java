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

import com.sltk.app.dao.PlantDao;
import com.sltk.app.model.Plant;

@RestController
@RequestMapping("/plant")
public class PlantController {

	@Autowired
	private PlantDao plantDao;

	@RequestMapping(value = "/plantupload", method = RequestMethod.POST)
	public String savePlant(@Valid @RequestBody List<Plant> plant) throws IOException {
		
		FileInputStream file = new FileInputStream(new File("C:/Users/Desktop/data.csv")); 
		XSSFWorkbook workbook = new XSSFWorkbook(file); 
		XSSFSheet sheet = workbook.getSheetAt(1); 
        Row row;
        for(int i=1; i<=sheet.getLastRowNum(); i++){  //points to the starting of excel i.e excel first row
            row = (Row) sheet.getRow(i);  //sheet number
            
            
	            String plant_id;
				if( row.getCell(0)==null) { plant_id = "0"; }
	            else plant_id= row.getCell(0).toString();

                   String name;
				if( row.getCell(1)==null) { name = "null";}  //suppose excel cell is empty then its set to 0 the variable
                   else name = row.getCell(1).toString();   //else copies cell data to name variable

                   String address1;
				if( row.getCell(2)==null) { address1 = "null";   }
                   else  address1   = row.getCell(2).toString();
				
				   String address2;
					if( row.getCell(3)==null) { address2 = "null";   }
	                   else  address2   = row.getCell(3).toString();
		
					   String city;
						if( row.getCell(4)==null) { city = "null";   }
		                   else  city   = row.getCell(4).toString();
						
						   String state;
							if( row.getCell(5)==null) { state = "null";   }
			                   else  state   = row.getCell(2).toString();
							
							   String country;
								if( row.getCell(6)==null) { country = "null";   }
				                   else  country   = row.getCell(6).toString();
								
								   String postalcode;
									if( row.getCell(7)==null) { postalcode = "0";   }
					                   else  postalcode   = row.getCell(7).toString();
	    Plant pl = new Plant();
	    
	    pl.setPlant(plant_id);
	    pl.setName(name);
	    pl.setAddress1(address1);
	    pl.setAddress2(address2);
	    pl.setCity(city);
	    pl.setState(state);
	    pl.setCountry(country);
	    pl.setPostalcode(Long.parseLong(postalcode));
	   System.out.println(pl.toString());
	  
	   plantDao.save(pl);
	}
		return "plant values saved";

	}
}
