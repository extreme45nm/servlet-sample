package edu.java.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(value="/upload",name="uploadServlet")
@MultipartConfig(maxFileSize=1024*1024*10)
public class UploadServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws IOException, ServletException{
		
		String appPath = rq.getServletContext().getRealPath("");
		File folder = new File(appPath,"temp");
		if(!folder.exists())folder.mkdir();
		
		System.out.println(" AppPath = "+appPath);
		for(Part part:rq.getParts()){
			
			String name = extractFileName(part);
			byte[] buff = new byte[1024*1024];
			int read = -1;
			FileOutputStream outputStream = new FileOutputStream(new File(folder,name));
			try{
				InputStream inputStream = part.getInputStream();
				while((read=inputStream.read(buff))!=-1){
					outputStream.write(buff);
				}
			}finally{
				outputStream.close();
			}
			
//			Collection<String> headers = part.getHeaderNames();
//			for(String header:headers){
//				rp.getWriter().println(header+" : "+part.getHeader(header));
//			}
		}
		
		rp.getWriter().println("Successfully upload file");
	}
	
	private String extractFileName(Part part){
		
		String content = part.getHeader("content-disposition");
		Pattern patt = Pattern.compile(".*filename\\=\"(.*)\".*");
		Matcher matt = patt.matcher(content);
		return matt.matches()?matt.group(1):"unknown????";
	}
}
