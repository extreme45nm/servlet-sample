package edu.java.web;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/redirect",name="redirect-servlet")
public class PagwRedirect extends HttpServlet{
	
	protected void doGet(HttpServletRequest rq,HttpServletResponse rep){
		
		rep.setContentType("text/html");
		String site = new String("http://www.google.com");
		rep.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
		rep.setHeader("Location", site);
	}
}
