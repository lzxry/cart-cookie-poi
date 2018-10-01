package com.liyin.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
	//cookie域，跨域时使用
	private static String domain="";
	//cookie有效期
	private static int maxAge=7*24 * 60 * 60 * 1000;//一周
	/**
	 * 设置cookie(新增、修改一样)
	 * @param response
	 * @param name cookie名字
	 * @param value  cookie值
	 * @param maxAge cookie生命周期 以秒为单位 setMaxAge(参数)：参数为负数代表关闭浏览器时清除cookie，参数为0时代表删除cookie，参数为正数时代表cookie存在多少秒。
	 */
	public static void addCookie(HttpServletResponse response,String name,String value) {
		Cookie cookie = new Cookie(name, value);
		if(domain != null && !domain.equals("")){
			cookie.setDomain(domain);
		}
		cookie.setPath("/");
		if (maxAge > 0){//-1随浏览器关闭而关闭；0马上关闭；>0生命周期（毫秒）
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
	}
	/**
	 * 根据名称获取cookie
	 * @author:yuewangh
	 * @time:2015年11月17日 上午11:02:14
	 * @param request
	 * @param name
	 * @return
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = ReadCookieMap(request);
		if (cookieMap.containsKey(name)) {
			Cookie cookie = (Cookie) cookieMap.get(name);
			return cookie;
		} else {
			return null;
		}
	}
	/**
	 * 根据名称获取cookie值
	 * @author:yuewangh
	 * @time:2015年11月17日 上午11:02:14
	 * @param request
	 * @param name
	 * @return
	 */
	public static String getCookieValueByName(HttpServletRequest request, String name) {
		Cookie cookie =getCookieByName(request,name);
		if(cookie != null){
			return cookie.getValue();
		}else{
			return "";
		}
	}

	/**
	 * 将cookie封装到Map里面
	 * 
	 * @param request
	 * @return
	 */
	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
	/**
	 * 删除cookie根据name
	 * @author:yuewangh
	 * @time:2015年11月17日 下午3:17:29
	 * @param response
	 * @param name
	 */
	public static void deleteCookie(HttpServletResponse response, String name) {
		Cookie cookie = new Cookie(name,""); 
        cookie.setMaxAge(0);  
        
        cookie.setPath("/");// 不要漏掉
        response.addCookie(cookie);
        System.out.println("删除key:"+cookie.getName()+"--MaxAge:"+cookie.getMaxAge());
	}
	/**
	 * 删除购物车所有商品
	 * @author:yuewangh
	 * @time:2015年11月17日 下午3:17:29
	 * @param response
	 * @param name
	 */
	public static void deleteAllCarGoods(HttpServletResponse response,HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName();
				if(name.startsWith(Const.COOKIE_CARGOOD_GOODSID)){
					deleteCookie(response,name);
				}
			}
		}
	}
	/**
	 *获取cookie里边的商品
	 * @param request
	 * @return
	 */
	public static List<Map<String,String>> getCookieCargoods(HttpServletRequest request) {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Cookie[] cookies = request.getCookies();
		if (null != cookies) {
			for (Cookie cookie : cookies) {
				Map<String,String> map = new HashMap<String,String>();
				String name = cookie.getName();
				if(name.startsWith("cart_")){
					map.put("id", name.replace("cart_", ""));
					map.put("num", cookie.getValue());
					list.add(map);
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
	
		
	}
}
