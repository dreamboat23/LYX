package com.example.lyxx;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Log4jtestApplicationTests {

	@Test
	void contextLoads() {
	}
	
	private Logger logger = Logger.getLogger(getClass());
	@Test
	public void test() throws Exception {
		logger.info("输出info");
		logger.debug("输出debug");
		logger.error("输出error");
	}

}
