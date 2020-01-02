package com.zhangguoming.maven.web.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangguoming.maven.web.entity.Area;
import com.zhangguoming.maven.web.entity.Hobby;
import com.zhangguoming.maven.web.entity.Student;

public interface StudentService {
	/**
	 * 查询分页列表
	 * @param student
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	public PageInfo<Student> getPageInfo(Student student,Integer pageNum,Integer pageSize);
	/**
	 * 根据id查询学生
	 * @param id
	 * @return
	 */
	public Student getById(Integer id);
	/**
	 * 保存
	 * @param student
	 * @return
	 */
	public boolean save(Student student);
	/**
	 * 根据Pid查询地区
	 * @param pid
	 * @return
	 */
	public List<Area> getAreaListByPid(Integer pid);
	
	/**
	 * 查询所有兴趣爱好
	 * @return
	 */
	public List<Hobby> getHobbyListAll();
	
	/**
	 * 根据学生Id，查询兴趣爱好Ids
	 * @param stuId
	 * @return
	 */
	public List<Integer> getHobbyIdListByStuId(Integer stuId);
	/**
	 * 根据Ids，删除学生
	 * @param ids
	 * @return
	 */
	public int delByIds(String ids);

}
