package com.gn.common.wrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MsgReqeustWrapper extends HttpServletRequestWrapper{

	public MsgReqeustWrapper(HttpServletRequest request) {
		super(request);
	}

	@Override
	public String getParameter(String name) {
		if(name.equals("msg")) {
			return super.getParameter(name)+"-gn-";
		} else {
			return super.getParameter(name);
		}
	}
	

}
