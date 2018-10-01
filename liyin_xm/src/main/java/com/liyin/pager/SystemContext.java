package com.liyin.pager;

/**
 * 分页的传递参数的工具类
 * @author 宋伟宁
 *
 */
public class SystemContext {

	private static ThreadLocal<Integer> offset= 
			new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> pagesize=
			new ThreadLocal<Integer>();
	
	public static int getOffset() {
		return offset.get();
	}
	public static void setOffset(int _offset) {
		SystemContext.offset.set(_offset);;
	}
	public static int getPagesize() {
		return pagesize.get();
	}
	public static void setPagesize(int _pagesize) {
		SystemContext.pagesize.set(_pagesize);
	}
	
	public static void removeOffset() {
		offset.remove();
	}
	
	public static void removePagesize() {
		pagesize.remove();
	}
	
	
}
