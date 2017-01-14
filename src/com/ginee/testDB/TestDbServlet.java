package com.ginee.testDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//setup connection variables
		String user = "springstudent";
		String password = "springstudent";
		
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String driver = "com.mysql.jdbc.Driver";
		
		
		//get connection to the database
		try {
			PrintWriter out = response.getWriter();
			
			out.println("connecting to database" + jdbcUrl);
			
			Class.forName(driver);
			
			Connection myconnecion = DriverManager.getConnection(jdbcUrl,user,password);
			
			out.println("SUCCESS!!!");
			
			myconnecion.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
	}

}