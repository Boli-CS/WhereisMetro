package com.pitaya.metro;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.runners.Parameterized.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pitaya.metor.enums.SZMetrosEnum;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, @RequestParam("metroID")String metroID) {
		switch (SZMetrosEnum.getInstance(Integer.parseInt(metroID))) {
		case LUO_BAO:
			
			break;
		case SHE_KOU:
			
			break;
		case LONG_GANG:
			
			break;
		case LONG_HUA:
			
			break;
		case HUAN_ZHONG:
			
			break;

		default:
			break;
		}	
		return "home";
	}
	
	
	
}
