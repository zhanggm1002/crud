package com.zhangguoming.maven.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
//	private Logger logger = LoggerFactory.getLogger(getClass());
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	@RequestMapping("/hello")
	public String hello() {
		logger.info("hello:{}{}{}","zhangsan","1","2");
//		System.out.println("hello");
		return "hello";
	}

}
