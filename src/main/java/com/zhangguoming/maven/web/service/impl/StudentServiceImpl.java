package com.zhangguoming.maven.web.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangguoming.maven.web.dao.StudentDao;
import com.zhangguoming.maven.web.entity.Area;
import com.zhangguoming.maven.web.entity.Hobby;
import com.zhangguoming.maven.web.entity.Student;
import com.zhangguoming.maven.web.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public PageInfo<Student> getPageInfo(Student student, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Student> studentList = studentDao.select(student);
		return new PageInfo<Student>(studentList);
	}

	@Override
	public Student getById(Integer id) {
		return studentDao.selectById(id);
	}

	@Override
	public boolean save(Student student) {
		if(student.getId()==null) {
			student.setCreate_time(new Date());
			studentDao.insert(student);
		}else {
			 if(student.getHeader_img()==null) {
				 Student stu = studentDao.selectById(student.getId());
				 student.setHeader_img(stu.getHeader_img());
			 }
			 studentDao.update(student);
			 //删除关系表数据
			 studentDao.deleteStudentHobbyRelation(student.getId());
		}
	    //插入关系表数据
	    List<Integer> hobbyIds = student.getHobbyIds();
	    studentDao.insertStudentHobbyRelation(student.getId(),hobbyIds);
	    return true;
	}

	@Override
	public List<Area> getAreaListByPid(Integer pid) {
		return studentDao.selectAreaByPid(pid);
	}

	@Override
	public List<Hobby> getHobbyListAll() {
		return studentDao.selectHobbyAll();
	}
	
	@Override
	public List<Integer> getHobbyIdListByStuId(Integer stuId) {
		return studentDao.selectHobbyIdListByStuId(stuId);
	}

	@Override
	public int delByIds(String ids) {
		return studentDao.delete(ids);
	}
	
	
}
