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

import com.sltk.app.dao.PrheaderDao;
import com.sltk.app.entity.sap.PrheaderSapEntity;
import com.sltk.app.entity.sap.PrlineItemsSapEntity;
import com.sltk.app.model.Prheader;
import com.sltk.app.model.PrlineItems;

@RestController
@RequestMapping("/pr")
public class PrHeaderController {

	@Autowired
	private PrheaderDao prheaderDao;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createPrDetails(@Valid @RequestBody List<PrheaderSapEntity> entities) {

		System.out.println(entities.toString());
		List<Prheader> prheadersList = new ArrayList<Prheader>();
		for (PrheaderSapEntity prheaderSapEntity : entities) {
			Prheader prheader = new Prheader();
			prheader.setPrNumber(Long.parseLong(prheaderSapEntity.getPr_number()));
			prheader.setPrDescription(prheaderSapEntity.getPr_description());

			List<PrlineItems> prlineItemsList = new ArrayList<PrlineItems>();
			List<PrlineItemsSapEntity> itemsSapEntities = prheaderSapEntity.getPrlineitemslist();

			for (PrlineItemsSapEntity prlineItemsSapEntity : itemsSapEntities) {
				PrlineItems items = new PrlineItems();
				items.setPrnumber(prheader);
				items.setPrLineId(prlineItemsSapEntity.getPr_line_number());
				items.setDesciption(prlineItemsSapEntity.getDescription());
				items.setMeterialNumber(prlineItemsSapEntity.getMaterialnumber());
				items.setMeterialCatagory(prlineItemsSapEntity.getMaterialcatagory());
				items.setOrderQty(new BigDecimal(prlineItemsSapEntity.getOrderquantity()));
				items.setUom(prlineItemsSapEntity.getUom());
				items.setItemType(prlineItemsSapEntity.getItemtype());
				items.setPlant(prlineItemsSapEntity.getPlant());
				items.setCreatedDate(prlineItemsSapEntity.getPr_created_date());

				prlineItemsList.add(items);
			}
			prheader.setPrlineItems(prlineItemsList);
			prheadersList.add(prheader);
		}
		System.out.println(prheadersList.toString());
		prheaderDao.saveAll(prheadersList);
		System.out.println(prheadersList.toString());
		return "pr created";
	}
}
