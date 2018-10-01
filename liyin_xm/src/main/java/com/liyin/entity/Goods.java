package com.liyin.entity;

import java.io.Serializable;

public class Goods implements Serializable {

	private static long serialVersionUID = -8542556536639597113L;
	private String id;
	private String tid;
	private String name;
	private String price;
	private String img_path;
	private String madedate;
	private String createdate;
	private String status;
	private String gift;
	private String deletestatus;
	private String type;
	private String number;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(String id, String tid, String name, String price, String img_path, String madedate, String createdate,
			String status, String gift, String deletestatus, String type) {
		super();
		this.id = id;
		this.tid = tid;
		this.name = name;
		this.price = price;
		this.img_path = img_path;
		this.madedate = madedate;
		this.createdate = createdate;
		this.status = status;
		this.gift = gift;
		this.deletestatus = deletestatus;
		this.type = type;
	}
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	public static void setSerialVersionUID(long serialVersionUID) {
		Goods.serialVersionUID = serialVersionUID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getMadedate() {
		return madedate;
	}
	public void setMadedate(String madedate) {
		this.madedate = madedate;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGift() {
		return gift;
	}
	public void setGift(String gift) {
		this.gift = gift;
	}
	public String getDeletestatus() {
		return deletestatus;
	}
	public void setDeletestatus(String deletestatus) {
		this.deletestatus = deletestatus;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", tid=" + tid + ", name=" + name + ", price=" + price + ", img_path=" + img_path
				+ ", madedate=" + madedate + ", createdate=" + createdate + ", status=" + status + ", gift=" + gift
				+ ", deletestatus=" + deletestatus + ", type=" + type + "]";
	}
	
}
