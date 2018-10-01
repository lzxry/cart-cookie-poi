package com.liyin.pager;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;


/**
 * Servlet Filter implementation class SystemContextFilter
 */
@Component
@ServletComponentScan
@WebFilter("/*")
@WebInitParam(name="pager.offset",value="0")
public class SystemContextFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SystemContextFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		int offset=0;
		try {
			offset= Integer.parseInt(request.getParameter("pager.offset"));
		} catch (Exception e) {
			
		}
		try {
			SystemContext.setOffset(offset);
			SystemContext.setPagesize(3);
			chain.doFilter(request, response);
		} finally {
			 SystemContext.removeOffset();
			 SystemContext.removePagesize();
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
