package edu.java.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/count",name="hitCount")
public class HitCounter extends HttpServlet{
	private int hitCount;
	
	public void init(){
		hitCount=0;
	}
	
	protected void doGet(HttpServletRequest rq,HttpServletResponse rp) throws IOException{
		
		hitCount++;
		rp.setContentType("text/html");
		PrintWriter writer = rp.getWriter();
		
		writer.println("<html>");
		writer.println("<br>Hitcount = "+hitCount);
		writer.println("<html>");
	}
}
