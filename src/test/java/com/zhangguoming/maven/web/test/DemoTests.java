package com.zhangguoming.maven.web.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhangguoming.maven.web.service.DemoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class DemoTests {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	DemoService demoService;
	
	@Test
	public void test() {
		logger.info("开启事物");
		String hello = demoService.hello("zhangsan");
		logger.info("提交事物");
		logger.info("message:{}",hello);
	}
}
