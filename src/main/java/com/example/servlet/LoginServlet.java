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

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	static Log Log = LogFactory.getLog(LoginServlet.class);
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Log.info("#######");
		Log.info("doGet()");
		Log.info("#######");
		
		
		String error = request.getParameter("error");
		Log.info("error=["+error+"]");
		if(error != null)
			request.setAttribute("errorMessage", "ID, PW를 확인하세요");
		
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/loginform.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Log.info("########");
		Log.info("doPost()");
		Log.info("########");
		
		String id=request.getParameter("id");
		String pw=request.getParameter("pw");
		Log.info("id="+id); Log.info("pw"+pw);
		
		/*
		 *  인증처리(이건 db를 배워야 할 수 있는 것. 일단 가상으로 만들어보자)
		 */
		
		if ("hong".equals(id) && "1234".equals(pw)){
			//인증성공. id는 hong, pw=1234 
			Cookie login = new Cookie("login", "hong");
			login.setPath("/");
			//루트 이하의 패스에선 login, hong 쿠키를 계속 보내달라는 요청.
			response.addCookie(login);
			response.sendRedirect("/index.jsp");
		} else {
			//인증실패 
			response.sendRedirect("/login?error=true");	
			
		}
		 
	}
}
