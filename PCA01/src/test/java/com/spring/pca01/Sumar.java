package com.spring.pca01;

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
public class Sumar {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	int a, b;
	String operacion;

	@Before
	public void setUp() throws Exception {
		a = -6;
		b = 8;
		operacion = "sumar";
	}

	@Test
	public void test() {
		if (operacion.equals("sumar")) {
			if (a > 0 && b > 0) {
				logger.info("" + (a + b));
			} else {
				logger.info("Usted necesita ingresar valores positivos");
			}
		}
	}

}
