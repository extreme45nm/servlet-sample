package edu.java.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/htmlpage",name="html-servlet")
public class HtmlPageServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req,HttpServletResponse rep) throws IOException{
		
		PrintWriter writer = rep.getWriter();
		
		writer.println("<html><head><title>Welcome to NIGGA ZOOUU</title></head>");
		writer.println("<body><h1>Student</h1></body>");
		writer.println("<table border=1>");
		
		writer.println("<tr>");
		writer.println("<td>#");
		writer.println("</td>");
		writer.println("<td>Student");
		writer.println("</td>");
		writer.println("/<tr>");
		
		writer.println("<tr>");
		writer.println("<td>1");
		writer.println("</td>");
		writer.println("<td>Nguyen Vaan Nigg");
		writer.println("</td>");
		writer.println("/<tr>");
		
		writer.println("<tr>");
		writer.println("<td>2");
		writer.println("</td>");
		writer.println("<td>Tran Thi Aggin");
		writer.println("</td>");
		writer.println("/<tr>");
		
		writer.println("<tr>");
		writer.println("<td>3");
		writer.println("</td>");
		writer.println("<td>NANANA");
		writer.println("</td>");
		writer.println("/<tr>");
		
		writer.println("</table>");
		writer.println("</html>");
	}
}
