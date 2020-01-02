package com.zhangguoming.maven.web.entity;

import java.util.Date;
import java.util.List;

public class Student {
	
	private Integer id;
	private String name;
	private String header_img;
	private Integer provice_id;
	private Integer city_id;
	private Integer area_id;
	private Date create_time;
	
	//兴趣爱好Ids
	private List<Integer> hobbyIds;
	private String provice_name;
	private String city_name;
	private String area_name;
	
	public String getProvice_name() {
		return provice_name;
	}
	public void setProvice_name(String provice_name) {
		this.provice_name = provice_name;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	public String getArea_name() {
		return area_name;
	}
	public void setArea_name(String area_name) {
		this.area_name = area_name;
	}
	public List<Integer> getHobbyIds() {
		return hobbyIds;
	}
	public void setHobbyIds(List<Integer> hobbyIds) {
		this.hobbyIds = hobbyIds;
	}
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
	public String getHeader_img() {
		return header_img;
	}
	public void setHeader_img(String header_img) {
		this.header_img = header_img;
	}
	public Integer getProvice_id() {
		return provice_id;
	}
	public void setProvice_id(Integer provice_id) {
		this.provice_id = provice_id;
	}
	public Integer getCity_id() {
		return city_id;
	}
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}
	public Integer getArea_id() {
		return area_id;
	}
	public void setArea_id(Integer area_id) {
		this.area_id = area_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

}
