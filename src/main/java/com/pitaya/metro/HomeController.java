package com.pitaya.metro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pitaya.metro.domains.MetroCurrentStatusDomain;
import com.pitaya.metro.enums.MetroLineEnum;
import com.pitaya.metro.enums.MetroStationsEnum;
import com.pitaya.metro.service.CalculateMetroStatusService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	CalculateMetroStatusService calculateMetroStatusService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @RequestParam(value="metroID",required=false)String metroID) {
		Map<String, String> attributes = null;
		if (null == MetroLineEnum.getInstance(Integer.parseInt(metroID))) {
			return "notFound";
		}
		switch (MetroLineEnum.getInstance(Integer.parseInt(metroID))) {
		case LUO_BAO:
			attributes = generateAttributesMap(MetroLineEnum.LUO_BAO);
			break;
		case SHE_KOU:
			attributes = generateAttributesMap(MetroLineEnum.SHE_KOU);
			break;
		case LONG_GANG:
			attributes = generateAttributesMap(MetroLineEnum.LONG_GANG);
			break;
		case LONG_HUA:
			attributes = generateAttributesMap(MetroLineEnum.LONG_HUA);
			break;
		case HUAN_ZHONG:
			attributes = generateAttributesMap(MetroLineEnum.HUAN_ZHONG);
			break;

		default:
			break;
		}	
		if(null != attributes) {
			model.addAllAttributes(attributes);
		}
		
		return "home";
	}
	
	public Map<String, String> generateAttributesMap(MetroLineEnum lineEnum) {

		List<String> attributesList = new ArrayList<String>();
		Map<String, String> attributes = new HashMap<String, String>();
		
		MetroCurrentStatusDomain metroCurrentStatusDomain = 
				calculateMetroStatusService.getMetroCurrentStatus(lineEnum, MetroStationsEnum.getStartStation(lineEnum));
			attributes.put("title", lineEnum.getName());
			attributesList.add("罗宝线");
			
			attributes.put("end_station", MetroStationsEnum.getEndStation(lineEnum).getName());
			attributesList.add(MetroStationsEnum.getEndStation(lineEnum).getName());
			
			attributes.put("end_station_min", Long.toString(metroCurrentStatusDomain.getSeconds() / 60));
			attributesList.add(Long.toString(metroCurrentStatusDomain.getSeconds() / 60));
			
			attributes.put("end_station_sec", Long.toString(metroCurrentStatusDomain.getSeconds() % 60));
			attributesList.add(Long.toString(metroCurrentStatusDomain.getSeconds() % 60));
			
			metroCurrentStatusDomain = 
					calculateMetroStatusService.getMetroCurrentStatus(lineEnum, MetroStationsEnum.getEndStation(lineEnum));
			
			attributes.put("start_station", MetroStationsEnum.getStartStation(lineEnum).getName());
			attributesList.add(MetroStationsEnum.getStartStation(lineEnum).getName());
			
			attributes.put("start_station_min", Long.toString(metroCurrentStatusDomain.getSeconds() / 60));
			attributesList.add(Long.toString(metroCurrentStatusDomain.getSeconds() / 60));
			
			attributes.put("start_station_sec", Long.toString(metroCurrentStatusDomain.getSeconds() % 60));
			attributesList.add(Long.toString(metroCurrentStatusDomain.getSeconds() % 60));
			return attributes;
	}
	
}
