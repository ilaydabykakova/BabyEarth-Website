package com.javatpoint.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.bean.Baby;
import com.javatpoint.dao.BabyDao;
import javax.servlet.http.*;
@WebServlet("/ViewBabyNameByReligion")
public class ViewBabyNameByReligion extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String religion=request.getParameter("religion");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Baby by "+religion.toUpperCase()+"</title>");
		out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navigation.html").include(request, response);
		out.print(" <a href='ViewBabyNameByReligion?religion=Hindu' class='btn btn-primary' role='button'>Hindu</a> ");
		out.print(" <a href='ViewBabyNameByReligion?religion=Muslim' class='btn btn-primary' role='button'>Muslim</a> ");
		out.print(" <a href='ViewBabyNameByReligion?religion=Jewish' class='btn btn-primary' role='button'>Jewish</a> ");
		out.print(" <a href='ViewBabyNameByReligion?religion=Christian' class='btn btn-primary' role='button'>Christian</a> ");
		out.print(" <a href='ViewBabyNameByReligion?religion=Other' class='btn btn-primary' role='button'>Other</a> ");
		request.getRequestDispatcher("atoz.html").include(request, response);
		
		out.println("<h1>View Baby Names by "+religion+"</h1>");
		List<Baby> list=BabyDao.getRecordsByReligion(religion);
		
		out.print("<table class='table table-bordered table-striped'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Meaning</th><th>Gender</th><th>Religion</th></tr>");
		for(Baby b:list){
			out.println("<tr><td>"+b.getId()+"</td><td>"+b.getName()+"</td><td>"+b.getMeaning()+"</td><td>"+b.getGender()+"</td><td>"+b.getReligion()+"</td></tr>");
		}
		out.println("</table>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}


}
