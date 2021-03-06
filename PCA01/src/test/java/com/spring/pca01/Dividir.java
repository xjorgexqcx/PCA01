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
public class Dividir {

	private static final Logger logger = LoggerFactory.getLogger(Dividir.class);

	int a, b;
	String operacion;

	@Before
	public void setUp() throws Exception {
		a = 5;
		b = 2;
		operacion = "dividir";
	}

	@Test
	public void test() {
		if (operacion.equals("dividir")) {
			if (b > 0) {
				long div = a / b;
				logger.info("Resultado: " + div);
			} else {
				logger.info("La division entre 0 no es valida");
			}
		}
	}

}
