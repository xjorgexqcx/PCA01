package com.spring.pca01;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.pca01.clases.SumarService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	long time_start, time_end;
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private SumarService sumarService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		return "home";
	}

	@RequestMapping(value = "operaciones", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	public String home(@RequestParam("a") Integer a,
			@RequestParam("b") Integer b,
			@RequestParam("operacion") String operacion) {
		time_start = System.currentTimeMillis();
		SumarService su = new SumarService();
		time_end = System.currentTimeMillis();
		logger.info("Tiempo transcurrido: " + (time_end - time_start)
				+ " milisegundos");
		logger.info("Tiempo de inicio" + time_start);
		logger.info("Tiempo de termino" + time_end);
		String rpta = su.Operacion(operacion, a, b);
		return rpta;
	}
	
}
