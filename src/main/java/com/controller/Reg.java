package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DBConnection.DbConfig;
/**
 * Servlet implementation class Reg
 */
@WebServlet("/reg")
public class Reg extends HttpServlet {
	String empid;
	String ename;
	String address;
	String salary;
	String pass;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		empid = request.getParameter("empid");
//		ename = request.getParameter("ename");
//		address = request.getParameter("address");
//		salary = request.getParameter("salary");
//		
//		PrintWriter out = response.getWriter();
//		out.print(empid);
//		out.print(ename);
//		out.print(address);
//		out.print(salary);
//		out.println("record inserted");
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			empid = request.getParameter("empid");
			ename = request.getParameter("ename");
			address = request.getParameter("address");
			salary = request.getParameter("salary");
			pass = request.getParameter("pass");
			
			DbConfig d = new DbConfig();
			Connection con = d.getCon();
			PreparedStatement p = con.prepareStatement("insert into Employee values (?,?,?,?,?)");
			p.setString(1, empid);
			p.setString(2, ename);
			p.setString(3, address);
			p.setString(4, salary);
			p.setString(5, pass);
			p.executeUpdate();
			p.close();
			con.close();
			PrintWriter out = response.getWriter();
			out.println(empid);
			out.println(ename);
			out.println(address);
			out.println(salary);
			out.println("record inserted");
		}
		catch(Exception r) {
			System.out.println(r);
		}
	}

}
