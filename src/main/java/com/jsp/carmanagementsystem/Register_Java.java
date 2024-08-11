package com.jsp.carmanagementsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register_Java  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("userName");
		int userPhone = Integer.parseInt(req.getParameter("userPhone"));
		String userEmail = req.getParameter("userEmail");
		String userPassword = req.getParameter("userPassword");
		String confirmPassword = req.getParameter("confirmPassword");
		
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/carmanagementsystem?user=root&password=root123");
			
			if(userPassword.equals(confirmPassword)) {
				PreparedStatement pst = conn.prepareStatement("INSERT INTO user (userName, userPhone, userEmail, userPassword) VALUES(?,?,?,?)");
				pst.setString(1, userName);
				pst.setInt(2, userPhone);
				pst.setString(3, userEmail);
				pst.setString(4, userPassword);
				
				int rowsInserted = pst.executeUpdate();
				
				if(rowsInserted > 0) {
					resp.sendRedirect("Home.jsp");
				}
			
				
			}else {
				resp.sendRedirect("error.jsp");
			}
			
					
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
