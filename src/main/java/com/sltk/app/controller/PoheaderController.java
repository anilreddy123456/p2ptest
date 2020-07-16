package com.sltk.app.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.app.dao.PoheaderDao;
import com.sltk.app.entity.sap.PoheaderSapEntity;
import com.sltk.app.entity.sap.PolineServiceSapEntity;
import com.sltk.app.entity.sap.PolineTaxSapEntity;
import com.sltk.app.entity.sap.PolineitemsSapEntity;
import com.sltk.app.model.Poheader;
import com.sltk.app.model.PolineItemServices;
import com.sltk.app.model.PolineItemTaxes;
import com.sltk.app.model.Polineitems;
import com.sltk.app.model.Prheader;

import javassist.NotFoundException;

@RestController
@RequestMapping("/header")
public class PoheaderController {

	// private static final Logger
	// logger=LoggerFactory.getLogger(PoheaderController.class);
	@Autowired
	private PoheaderDao poheaderDao;

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	@Transactional
	public List<Poheader> getAllHeader() {

		// logger.debug("debugging mode getall() method");
		List<Poheader> h = (List<Poheader>) poheaderDao.findAll();
		return h;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	@Transactional
	public Poheader getHeaderByID(@PathVariable("id") Long id) throws NotFoundException {
		Optional<Poheader> optHeader = poheaderDao.findById(id);
		if (optHeader.isPresent()) {
			return optHeader.get();
		} else {
			throw new NotFoundException("Header not found with id " + id);
		}
	}

	@RequestMapping(value = "/save/update", method = RequestMethod.POST)
	@Transactional
	public String createHeader(@Valid @RequestBody List<PoheaderSapEntity> header) throws ParseException {

		System.out.println(header.toString());
		
		List<Poheader> headerlist=new ArrayList<Poheader>();
				
		for (PoheaderSapEntity poheaderSapEntity : header) {
			Poheader poheader = new Poheader();
			poheader.setPonumber(Long.parseLong(poheaderSapEntity.getPonumber()));
			poheader.setVendorSapCode(poheaderSapEntity.getVendorsapcode());
			poheader.setDescription(poheaderSapEntity.getDescription());
			poheader.setPotype(poheaderSapEntity.getPotype());
			poheader.setDocDate(poheaderSapEntity.getDocdate());
			poheader.setPurchaser(poheaderSapEntity.getPurchaser());
			poheader.setOtherCharges(new BigDecimal(0.00));
			poheader.setNetValue(new BigDecimal(poheaderSapEntity.getNetvalue()));
			poheader.setTaxValue(new BigDecimal(poheaderSapEntity.getTaxvalue()));
			poheader.setGrossValue(new BigDecimal(poheaderSapEntity.getGrossvalue()));
			poheader.setCurrency(poheaderSapEntity.getCurrency());
			poheader.setCreatedDate(poheaderSapEntity.getCreateddate());
			poheader.setLastModifiedDate(poheaderSapEntity.getLastmodifieddate());
			/**
			//input date format
			 SimpleDateFormat df_in = new SimpleDateFormat("yyyyMMdd");
			 
			//output date format
			 SimpleDateFormat df_output = new SimpleDateFormat("yyyy-MM-dd");
			 Date date = df_in.parse(poheaderSapEntity.getCreateddate());
			String date1 = df_output.format(date);
			 
			poheader.setCreatedDate(date);
			poheader.setLastModifiedBy(poheaderSapEntity.getLastmodifiedby());
			poheader.setLastModifiedDate(new Date(poheaderSapEntity.getLastmodifieddate()));
			**/
			poheader.setPayTerms(poheaderSapEntity.getPay_term());
			
			List<PolineitemsSapEntity> polineitemsSapEntities = poheaderSapEntity.getPolineitemslist();
			List<Polineitems> polineitemslist= new ArrayList<Polineitems>();
			for (PolineitemsSapEntity polineitemsSapEntity : polineitemsSapEntities) {
				Polineitems polineitems = new Polineitems();
				if(polineitemsSapEntity.getPr_number()==null||polineitemsSapEntity.getPr_number()==" ") {
					polineitems.setPr_number(null);
				}else {
				Prheader pr= new Prheader(polineitemsSapEntity.getPr_number());
				polineitems.setPr_number(pr);
				}
				BigDecimal orderOqantity=new BigDecimal(polineitemsSapEntity.getOrderquantity());
				
				polineitems.setPonumber(poheader);
				polineitems.setAsnStatus(polineitemsSapEntity.getAsnstatus());
				polineitems.setPoLineId(Integer.parseInt(polineitemsSapEntity.getPolineid()));
				polineitems.setItemType(polineitemsSapEntity.getItemtype());
				polineitems.setDeliveryDate(polineitemsSapEntity.getDeliverydate());
				polineitems.setMaterialNumber(polineitemsSapEntity.getMaterialnumber());
				polineitems.setDescription(polineitemsSapEntity.getDescription());
				polineitems.setPlant(polineitemsSapEntity.getPlant());
				polineitems.setMaterialCatagory(polineitemsSapEntity.getMaterialcatagory());
				polineitems.setOrderQuantity(new BigDecimal(polineitemsSapEntity.getOrderquantity()));
				polineitems.setUom(polineitemsSapEntity.getUom());
				polineitems.setSapTaxCode(polineitemsSapEntity.getTaxcode());
				polineitems.setBalanceAsnQty(orderOqantity);
				polineitems.setGrossValue(orderOqantity.multiply(new BigDecimal(polineitemsSapEntity.getNetvalue())));
				polineitems.setNetValue(new BigDecimal(polineitemsSapEntity.getNetvalue()));
				if(polineitemsSapEntity.getPreviousasnqty()==null) {
				polineitems.setPreviousAsnQty(new BigDecimal(0));	
				}else {
					polineitems.setPreviousAsnQty(new BigDecimal(polineitemsSapEntity.getPreviousasnqty()));
				}
				if(polineitemsSapEntity.getPr_line_number()==null) {
					polineitems.setPrLineNo(null);
				}else {
				polineitems.setPrLineNo(Integer.parseInt(polineitemsSapEntity.getPr_line_number()));
				}
				
				List<PolineTaxSapEntity> polineTaxSapEntities = polineitemsSapEntity.getPotax();
				List<PolineItemTaxes> polineItemTaxeslist= new ArrayList<PolineItemTaxes>();
				for (PolineTaxSapEntity polineitemsTaxSapEntity : polineTaxSapEntities) {
					PolineItemTaxes polineItemTaxes = new PolineItemTaxes();
					
					polineItemTaxes.setLine_id(polineitems);
					polineItemTaxes.setTaxDescription(polineitemsTaxSapEntity.getTax_description());
					if(polineitemsTaxSapEntity.getTax_rate()==null||polineitemsTaxSapEntity.getTax_rate()==" ") {
						polineItemTaxes.setTaxRate(new BigDecimal(0.00));
					}else {
					polineItemTaxes.setTaxRate(new BigDecimal(polineitemsTaxSapEntity.getTax_rate()));
					}
					polineItemTaxeslist.add(polineItemTaxes);
				}
				
				List<PolineServiceSapEntity> polineserviceSapEntities =polineitemsSapEntity.getPoservicelineitem();
				List<PolineItemServices> itemServicesList = new ArrayList<PolineItemServices>();
				for (PolineServiceSapEntity polineItemServiceSApEntity : polineserviceSapEntities) {
					PolineItemServices itemServices =new PolineItemServices();
				
					itemServices.setPonumber(poheader);
					itemServices.setLine_id(polineitems);
					itemServices.setServiceNo(polineItemServiceSApEntity.getService_no());
					itemServices.setServiceLineNo(Long.parseLong(polineItemServiceSApEntity.getService_line_no()));
					itemServices.setPoLineId(polineItemServiceSApEntity.getPo_line_id());
					itemServices.setDescription(polineItemServiceSApEntity.getDescription());
					itemServices.setQuantity(new BigDecimal(polineItemServiceSApEntity.getQuantity()));
					itemServices.setUom(polineItemServiceSApEntity.getUom());
					itemServices.setGrosPrice(new BigDecimal(polineItemServiceSApEntity.getGross_price()));
					
					
					itemServicesList.add(itemServices);
				}
				polineitems.setPolineItemTaxes(polineItemTaxeslist);				
				polineitems.setPolineItemServices(itemServicesList);
				polineitemslist.add(polineitems);
			}		
			poheader.setPolineitemsList(polineitemslist);
			headerlist.add(poheader);
			if(!poheaderDao.existsById(poheader.getPonumber())) {
				poheaderDao.saveAll(headerlist);	        
		        System.out.println(headerlist.toString());
		        System.out.println("header created");
			}else {
				poheaderDao.save(poheader);
				System.out.println(headerlist.toString());
		        System.out.println("header updated");
			}
		}
		//if(!poheaderDao.existsById())
		
        return "header data";
				
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	@Transactional
	public ResponseEntity<Object> update(@PathVariable("id") Long id, @Valid @RequestBody Poheader header) {

		Optional<Poheader> headerObject = poheaderDao.findById(id);

		if (!headerObject.isPresent())
			return ResponseEntity.notFound().build();

		poheaderDao.save(header);

		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@Transactional
	public ResponseEntity<Object> deleteHeader(@PathVariable("id") Long id) throws NotFoundException {
		System.out.println("delete this " + id + " from header");
		Optional<Poheader> obj = poheaderDao.findById(id);
		if (!obj.isPresent())
			return ResponseEntity.notFound().build();
		poheaderDao.deleteById(id);
		return ResponseEntity.ok().build();

	}
}
