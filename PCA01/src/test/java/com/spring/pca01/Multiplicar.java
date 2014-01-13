package com.spring.pca01;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class Multiplicar {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	int a, b;
	String operacion;

	@Before
	public void setUp() throws Exception {
		a = 2;
		b = 5;
		operacion = "multiplicar";
	}

	@Test
	public void test() {
		assertEquals(10, (a * b));
		if (operacion.equals("multiplicar")) {
			String rpta = "Resultado " + (a * b);
			logger.info(rpta);
		}
	}
}
