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
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.DBConnection.DbConfig;

/**
 * Servlet implementation class view
 */
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		try {
			HttpSession s1 = request.getSession();
			String empid= (String)s1.getAttribute("empid"); ///by default returns object
			
			DbConfig d= new DbConfig();
			Connection c= d.getCon();
			
			PreparedStatement ps=c.prepareStatement("select * from Employee where empid=?");
			ps.setString(1,empid);
			ResultSet rs = ps.executeQuery();
			out.println("<table border=1>");
			if(rs.next()) {
				out.println("<tr><td>"+rs.getString(1)+ "</td><td>" +rs.getString(2) + "</td><td>"+rs.getString(3)+"</td></tr>");
				
//				RequestDispatcher rd = request.getRequestDispatcher("viewprofile.html");
//				rd.forward(request, response);
//				out.println("</table>");
				}
				
			else {
				out.println("record not updated");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}


}
