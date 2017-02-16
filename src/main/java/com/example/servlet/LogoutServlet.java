package com.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	static Log Log = LogFactory.getLog(LogoutServlet.class);
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Log.info("########");
		Log.info("doPost()");
		Log.info("########");
		
		Cookie logout = new Cookie("login", "hong");
		
		logout.setPath("/");
		logout.setMaxAge(0); //setMaxAge 쿠키가 살아있는 시간:0초로 만들라는 뜻임. 그러니까 삭제하라는 뜻.  
		response.addCookie(logout);
		
		response.sendRedirect("/index.jsp");
		 
	}
}
