package com.liyin.pager;

import java.util.List;

/**
 * 分页的工具类
 * @author 宋伟宁
 *
 */
public class Pager<T> {

	 private int offset;
	 private int pagesize;
	 private List<T> datas;
	 private long total;
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	 
	 
	 
}
