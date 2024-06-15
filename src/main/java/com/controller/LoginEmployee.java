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
import java.sql.ResultSet;
import java.sql.SQLException;

import com.DBConnection.DbConfig;

/**
 * Servlet implementation class LoginEmployee
 */
public class LoginEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		try {
		String empid = request.getParameter("empid");
		String pass = request.getParameter("pass");
		
		DbConfig d = new DbConfig();
		Connection c = d.getCon();
		PreparedStatement ps = c.prepareStatement("select * from Employee where empid = ? and pass = ?");
		ps.setString(1, empid);
		ps.setString(2, pass);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			HttpSession s1 = request.getSession();
			s1.setAttribute("empid", empid);
			s1.setAttribute("pass", pass);
			RequestDispatcher rd = request.getRequestDispatcher("empprofile.html");
			rd.forward(request, response);
			//out.println("record found");
		}
		else {
			response.sendRedirect("Login.html");
			//out.println("record not found");
		}
		}
		catch (SQLException e) {	
			e.printStackTrace();
		}
	}

}
