package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DBConnection.DbConfig;

/**
 * Servlet implementation class changep
 */

public class changep extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			HttpSession s1 = request.getSession();
		String empid= (String)s1.getAttribute("empid");
		String pass= request.getParameter("npass");
		
		DbConfig d= new DbConfig();
		Connection c= d.getCon();
		
		PreparedStatement ps=c.prepareStatement("update Employee set pass=? where empid=?");
		ps.setString(1, pass);
		ps.setString(2,empid);
		int count=ps.executeUpdate();
		if(count>0)
			{
			RequestDispatcher rd= request.getRequestDispatcher("empprofile.html");//url/html/jsp
			rd.forward(request, response);
			
			}
		else
			out.println("record not updated");
		
		
		}catch(Exception e) {}
		
	}

}
