package com.zhangguoming.maven.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangguoming.maven.web.dao.StudentDao;
import com.zhangguoming.maven.web.entity.Area;
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
			return studentDao.insert(student)>0;
		}
		return studentDao.update(student)>0;
	}

	@Override
	public List<Area> getAreaListByPid(Integer pid) {
		return studentDao.selectAreaByPid(pid);
	}
}
