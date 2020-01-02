
package com.zhangguoming.maven.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhangguoming.maven.web.entity.Area;
import com.zhangguoming.maven.web.entity.Hobby;
import com.zhangguoming.maven.web.entity.Student;


public interface StudentDao {
	
	List<Student> select(Student  student);
	
	int update(Student  student);
	
	int insert(Student  student);
	
	int delete(@Param("ids") String ids);

	Student selectById(Integer id);
	
	List<Area> selectAreaByPid(Integer pid);
	
	List<Hobby>selectHobbyAll();

	int deleteStudentHobbyRelation(Integer stuId);

	int insertStudentHobbyRelation(@Param("stuId") Integer stuId,@Param("hobbyIds") List<Integer> hobbyIds);
	
	List<Integer> selectHobbyIdListByStuId(Integer stuId);
}
