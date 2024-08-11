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

@WebServlet("/AddCar")
public class AddCarJava extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String carModel = req.getParameter("carModel");
		String carBrand = req.getParameter("carBrand");
		int carPrice = Integer.parseInt(req.getParameter("carPrice"));
		
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/carmanagementsystem?user=root&password=root123");

			PreparedStatement pst = conn.prepareStatement("INSERT INTO car (carModel,carBrand,carPrice) VALUES(?,?,?)");
			pst.setString(1, carModel);
			pst.setString(2, carBrand);
			pst.setInt(3, carPrice);

			pst.execute();

			resp.sendRedirect("Home.jsp");


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
