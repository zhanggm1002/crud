package com.zhangguoming.maven.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhangguoming.maven.web.entity.Area;
import com.zhangguoming.maven.web.entity.Hobby;
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
		//兴趣爱好
		List<Hobby> hobbyList = studentService.getHobbyListAll();
		model.addAttribute("hobbyList", hobbyList);
		if(id!=null) {
			Student student = studentService.getById(id);
			model.addAttribute("student", student);
			//查询市
			List<Area> cityList = studentService.getAreaListByPid(student.getProvice_id());
			model.addAttribute("cityList", cityList);
			//查询区
			List<Area> areaList = studentService.getAreaListByPid(student.getCity_id());
			model.addAttribute("areaList", areaList);
			//查兴趣爱好Ids
			List<Integer> hobbyIdList = studentService.getHobbyIdListByStuId(student.getId());
			student.setHobbyIds(hobbyIdList);
		}
		return "update";
	}
	
	@RequestMapping("save")
	public @ResponseBody Object save(Student student,@RequestParam(value="file",defaultValue="null") MultipartFile file) {
		//保存文件
		if(file.getSize()!=0) {
			String saveFile = saveFile(file);
			student.setHeader_img(saveFile);
		}
		return studentService.save(student);
	}
	/**
	 * 保存文件
	 * @param file
	 * @return
	 */
	public String saveFile(MultipartFile file) {
		String dest = "D:/pic/";
		//处理filename
		String originalFilename = file.getOriginalFilename();
		String extName = originalFilename.substring(originalFilename.indexOf("."));
		String fileName = UUID.randomUUID().toString()+extName;
		
		String fullFileName = dest+fileName;
		try {
			file.transferTo(new File(fullFileName));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "/pic/"+fileName;
	}
	
	@RequestMapping("getAreaListByPid")
	public @ResponseBody Object getAreaListByPid(Integer pid) {
		return studentService.getAreaListByPid(pid);
	}
	
	@RequestMapping("delByIds")
	public @ResponseBody Object delByIds(String ids) {
		return studentService.delByIds(ids)>0;
	}
}
