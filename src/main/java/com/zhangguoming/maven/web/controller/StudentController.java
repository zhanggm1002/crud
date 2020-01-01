package com.zhangguoming.maven.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhangguoming.maven.web.entity.Area;
import com.zhangguoming.maven.web.entity.Student;
import com.zhangguoming.maven.web.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("list")
	public String getPageInfo(Student student,@RequestParam(value="pageNum",defaultValue="1") Integer pageNum,Model model) {
		model.addAttribute("pageInfo", studentService.getPageInfo(student, pageNum, 3));
		return "list";
	}
	
	@RequestMapping("update")
	public String update(Integer id,Model model) {
		//查询省
		List<Area> proviceList = studentService.getAreaListByPid(1);
		model.addAttribute("proviceList", proviceList);
		if(id!=null) {
			Student student = studentService.getById(id);
			model.addAttribute("student", student);
			//查询市
			List<Area> cityList = studentService.getAreaListByPid(student.getProvice_id());
			model.addAttribute("cityList", cityList);
			//查询区
			List<Area> areaList = studentService.getAreaListByPid(student.getCity_id());
			model.addAttribute("areaList", areaList);
		}
		return "update";
	}
	
	@RequestMapping("save")
	public @ResponseBody Object save(Student student) {
		return studentService.save(student);
	}
	
	@RequestMapping("getAreaListByPid")
	public @ResponseBody Object getAreaListByPid(Integer pid) {
		return studentService.getAreaListByPid(pid);
	}
}
