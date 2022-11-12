package com.jdc.mkt;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = "/parameter",
		name = "parameterName",
		
		initParams = {
				@WebInitParam(name = "age",value="23"),
				@WebInitParam(name = "phone",value="092232323")
		}
		)

public class ParameterServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//servlet information
		var params = getInitParameterNames();
		
		while (params.hasMoreElements()) {
			var param=params.nextElement();
			System.out.println(String.format("%s : %s",param,getInitParameter(param)));
			
		}
		System.out.println("Servlet Info :" + getServletInfo());
		System.out.println("Servlet Name:" + getServletName());
		System.out.println("Servlet Config :" + getServletConfig());
		System.out.println("Servlet Context :" + getServletContext());
		
		
		//request parameter information
		
		String name=req.getParameter("name");
		String password=req.getParameter("pass");
		
		System.out.println(String.format("Name :%s Password :%s" , name,password));
		
		var reqParams=req.getParameterNames();
		
		while (reqParams.hasMoreElements()) {
			var reqParam = reqParams.nextElement();
			System.out.println(String.format("%s : %s", reqParam,req.getParameter(reqParam)));
			
		}
		
		//get information from http protocol
		System.out.println("Servlet Path:" + req.getServletPath());
		System.out.println("Context Path :" + req.getContextPath());
		System.out.println("Path Info :"+req.getPathInfo());
		
		
		var header=req.getHeaderNames();
		
		while (header.hasMoreElements()) {
			var head =  header.nextElement();
			System.out.println(String.format("%s: %s", head,req.getHeader(head)));
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var name=req.getParameter("user");
		var pass=req.getParameter("pass");
		
		resp.getWriter().append("""
				<!DOCTYPE html>
				<html>
				<head>
				<meta charset="ISO-8859-1">
				<title>Insert title here</title>
				</head>
				<body>
				""");
		resp.getWriter().append("<h1>User Information</h1><br/>");
		resp.getWriter().append("<p>User Name :"+name+"</p>");
		resp.getWriter().append("<p>Password:" + pass + "</p>");
		
		resp.getWriter().append("""
				</body>
				</html>
				""");
	}
	
	@Override
	public String getServletInfo() {
		return "parameter-test";
	}
}
