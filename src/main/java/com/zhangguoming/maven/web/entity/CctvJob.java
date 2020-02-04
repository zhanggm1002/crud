package com.zhangguoming.maven.web.entity;

public class CctvJob {
	/** 主键 **/
	private Integer id;
	/** 职位名称 **/
	private String name;
	/** 最低学历要求 **/
	private Integer require_edu;
	/** 最低学位要求 **/
	private Integer require_degree;
	/** 职位说明 **/
	private String intro;
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
	public Integer getRequire_edu() {
		return require_edu;
	}
	public void setRequire_edu(Integer require_edu) {
		this.require_edu = require_edu;
	}
	public Integer getRequire_degree() {
		return require_degree;
	}
	public void setRequire_degree(Integer require_degree) {
		this.require_degree = require_degree;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	
}
