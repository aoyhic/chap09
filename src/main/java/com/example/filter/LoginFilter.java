package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


//모든 url에 할거임? 특정 url에만 할거임? (/*)슬래쉬 밑에 모든 url에 적용할거야! ㄹ는 뜻 
@WebFilter("/admin/*")
public class LoginFilter implements Filter{
	static Log log = LogFactory.getLog(LoginFilter.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		log.info("###########");
		log.info("doFilter()");
		log.info("###########");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Cookie[] cookies = req.getCookies();
		
		boolean login = false;
		
		for (Cookie c : cookies){
			String name = c.getName();
			if ("login".equals(name))
				login = true;
			//쿠키이름이 로그인
			}
		
		if(login) //로그인이 되어 있으면 필터 통과
		chain.doFilter(request, response);
		else //안되어있으면 로그인해라!
			resp.sendRedirect("/login");
			
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}
