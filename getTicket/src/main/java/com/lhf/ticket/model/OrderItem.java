package com.lhf.ticket.model;

import java.util.Date;
import java.util.Set;

public class OrderItem {
	private Integer id;
	private String mobile;
	private Integer position_line;
	private Integer position_row;
	private Date time;
	private Boolean is_ordered;
	
	private String selected;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getPosition_line() {
		return position_line;
	}
	public void setPosition_line(Integer position_line) {
		this.position_line = position_line;
	}
	public Integer getPosition_row() {
		return position_row;
	}
	public void setPosition_row(Integer position_row) {
		this.position_row = position_row;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Boolean getIs_ordered() {
		return is_ordered;
	}
	public void setIs_ordered(Boolean is_ordered) {
		this.is_ordered = is_ordered;
	}
	public String getSelected() {
		return selected;
	}
	public void setSelected(String selected) {
		this.selected = selected;
	}
	
	@Override
	public String toString() {
		return selected.toString();
	}
}
