package com.gn.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

//@WebFilter(servletNames = "receiveDataServlet")
//@WebFilter("/receive/*")
//@WebFilter("/*")
@WebFilter("/receive/data")
public class DataFilter extends HttpFilter implements Filter{

	private static final long serialVersionUID = 1L;

	public DataFilter() {
		super();
		System.out.println("[DataFilter]기본 생성자 : 생성됨");
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("[DataFilter]init() : 필터 초기화");
	}

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("[DatFilter]요청 가로챔");
		chain.doFilter(request, response);
		System.out.println("[DataFilter]응답 가로챔");
	}
	
	@Override
	public void destroy() {
		System.out.println("[DataFilter]필터 종료");
	}


	
	
	

}
