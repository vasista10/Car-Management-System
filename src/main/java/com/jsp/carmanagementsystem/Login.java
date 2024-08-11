package com.jsp.carmanagementsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginSuccess")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userEmail = req.getParameter("userEmail");
		String userPassword = req.getParameter("userPassword");

		Connection conn = null;
		boolean isAuthenticated = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn  =  DriverManager.getConnection("jdbc:mysql://localhost:3306/carmanagementsystem?user=root&password=root123");

			PreparedStatement pst = conn.prepareStatement("SELECT * FROM user");


			pst.execute();

			ResultSet rs = pst.getResultSet();

			while (rs.next()) {
                String email = rs.getString("userEmail");
                String password = rs.getString("userPassword");

                if (userEmail.equals(email) && userPassword.equals(password)) {
                    isAuthenticated = true;
                    break;  // Exit the loop once a match is found
                }
            }

            if (isAuthenticated) {
                resp.sendRedirect("Home.jsp");
            } else {
                resp.sendRedirect("Error.jsp");
            }



		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
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
