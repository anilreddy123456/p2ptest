package com.sltk.app.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sltk.app.dao.GrnDao;
import com.sltk.app.dao.GrnDetailsDao;
import com.sltk.app.dao.PolineitemsDao;
import com.sltk.app.entity.sap.GrnDetailSapEntity;
import com.sltk.app.entity.sap.GrnSapEntity;
import com.sltk.app.model.Grn;
import com.sltk.app.model.Grndetails;
import com.sltk.app.model.Poheader;
import com.sltk.app.model.Polineitems;


@RestController
@RequestMapping("/grn")
public class GrnController {

	@Autowired
	private GrnDao grnDao;
	
	@Autowired
	private PolineitemsDao poLineItemDAO;
	
	@Autowired
	private GrnDetailsDao grndetailsdao;
	
	@RequestMapping(value="/getall",method=RequestMethod.GET)
	@Transactional
	public List<Grn> getAllGrns() {
		
		//logger.debug("debugging mode getall() method");
		List<Grn> grn = (List<Grn>) grnDao.findAll();
		return grn;
	}
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String saveGrn(@Valid @RequestBody List<Grn> grn) {
		
		System.out.println(grn.toString());
		grnDao.saveAll(grn);
		System.out.println(grn.toString());
		
		return "grn created";
		
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String createGrn(@Valid @RequestBody List<GrnSapEntity> grn) throws ParseException  {
				
		System.out.println(grn.toString());
		List<Grn> grnlist=new ArrayList<Grn>();
		
		for (GrnSapEntity grnSapEntity : grn) {
			Grn grn1= new  Grn();
			Poheader header= new Poheader(grnSapEntity.getPonumber());
			
			grn1.setGrnNumber(grnSapEntity.getGrnnumber());
			grn1.setGrnCreatedBy(grnSapEntity.getGrncreatedby());
			//grn1.setGrnCreatedDate(new SimpleDateFormat().parse(grnSapEntity.getGrncreateddate()));
			//grn1.setGrnPostingDate(new SimpleDateFormat().parse(grnSapEntity.getGrnpostingdate()));
			grn1.setGrnCreatedDate(grnSapEntity.getGrncreateddate());
			grn1.setGrnPostingDate(grnSapEntity.getGrnpostingdate());
			//grn1.setPonumber(new Poheader(grnSapEntity.getPonumber()));
			grn1.setPonumber(header);
		
			List<GrnDetailSapEntity> grndetails = grnSapEntity.getGrndetailslist();
			List<Grndetails> grndetilalist= new ArrayList<Grndetails>();
			for (GrnDetailSapEntity grndetailsentity : grndetails) {
				Grndetails grndetails1= new Grndetails();
				Polineitems poLineItems = poLineItemDAO.getPoLineItems(Long.parseLong(grnSapEntity.getPonumber()), Integer.parseInt(grndetailsentity.getPo_line_id()));
				grndetails1.setQuantity(new BigDecimal(grndetailsentity.getQuantity()));
				grndetails1.setGrnMovementType(grndetailsentity.getGrnmovementtype());
				grndetails1.setGrnNumber(new Grn(grndetailsentity.getGrnnumber()));
				grndetails1.setPonumber(header);
				grndetails1.setPlant(grndetailsentity.getPlant());
				grndetails1.setGrnItemId(grndetailsentity.getGrn_item_id());
				grndetails1.setLineId(poLineItems);
				//grndetails1.setLineId(Integer.parseInt(grndetailsentity.getLineid()));
				grndetails1.setPoLineId(grndetailsentity.getPo_line_id());
				grndetails1.setMatShortDesc(grndetailsentity.getMatshortdesc());
				grndetilalist.add(grndetails1);
			}			
	        grn1.setGrndetailsList(grndetilalist);
			grnlist.add(grn1);		
			 System.out.println(grn.toString());
		}
           grnDao.saveAll(grnlist);	
           
           System.out.println(grn.toString());
		
		return "grn created";
	
		
		}
		
		
	}

