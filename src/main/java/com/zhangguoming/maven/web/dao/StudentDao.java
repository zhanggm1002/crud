
package com.zhangguoming.maven.web.dao;

import java.util.List;

import com.zhangguoming.maven.web.entity.Area;
import com.zhangguoming.maven.web.entity.Student;


public interface StudentDao {
	
	List<Student> select(Student  student);
	
	int update(Student  student);
	
	int insert(Student  student);
	
	int delete(String ids);

	Student selectById(Integer id);
	
	List<Area> selectAreaByPid(Integer pid);
}
