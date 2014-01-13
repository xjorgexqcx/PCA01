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


public class restar {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	int a,b;
	
	@Before
	public void setUP() throws Exception{
		a=3;
		b=5;
		
	}
 
	
	
	@Test
	public void test() {
		logger.info("Resultado:"+ (a-b));
		
	}

}
