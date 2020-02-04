package com.zhangguoming.maven.web.entity;

import java.util.Date;

public class CctvApplicant {
	/** 主键 **/
	private Integer id;
	/** 应聘人 **/
	private String name;
	/** 性别:1男；2女 **/
	private String gender;
	/** 出生日期 **/
	private Date birthday;
	/** 毕业大学 **/
	private String college;
	/** 所学专业 **/
	private String major;
	/** 学历:1-专科，2-本科，3-研究生 **/
	private Integer edu;
	/** 学位:1-学士，2-硕士，3-博士 **/
	private Integer degree;
	/** 创建日期 **/
	private Date created;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public Integer getEdu() {
		return edu;
	}
	public void setEdu(Integer edu) {
		this.edu = edu;
	}
	public Integer getDegree() {
		return degree;
	}
	public void setDegree(Integer degree) {
		this.degree = degree;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
	
}
