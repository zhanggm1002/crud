package com.zhangguoming.maven.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zhangguoming.maven.web.service.CctvApplicantService;

@Controller
public class CctvApplicantController {
	@Autowired
	private CctvApplicantService applicantService;

}
