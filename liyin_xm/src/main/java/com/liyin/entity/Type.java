package com.liyin.entity;

public class Type {
	private Integer tid;
	private String name;
	private Integer pid;
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(Integer tid, String name, Integer pid) {
		super();
		this.tid = tid;
		this.name = name;
		this.pid = pid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Type [tid=" + tid + ", name=" + name + ", pid=" + pid + "]";
	}
	
}
