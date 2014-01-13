package com.spring.pca01;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.pca01.clases.SumarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class Tiempo {

	long time_start, time_end;

	@Autowired
	private SumarService sumarService;

	private static final Logger logger = LoggerFactory.getLogger(Tiempo.class);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		time_start = System.currentTimeMillis();
		String result = sumarService.Operacion("sumar", 1000000005, 8000);
		time_end = System.currentTimeMillis();
		logger.info("Tiempo transcurrido: " + (time_end - time_start)
				+ " milisegundos");
		logger.info("Tiempo de inicio" + time_start);
		logger.info("Tiempo de termino" + time_end);
	}
}
