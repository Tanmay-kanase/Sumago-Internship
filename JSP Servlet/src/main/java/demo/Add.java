package demo;

import java.util.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class JDBC
 */
@WebServlet("/add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DB_URL = "jdbc:mysql://localhost:3306/first";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "pokemon";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("add/html");
		PrintWriter out = response.getWriter();
		
        
        
       
        out.close();		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
        String rollNo = request.getParameter("rollNo");
        String age = request.getParameter("age");
        String marks= request.getParameter("marks");
        PrintWriter out = response.getWriter();
        
        
        try {
            // Load JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?useSSL=false", "root", "pokemon");

            // SQL Insert query
            String query = "INSERT INTO student (rollNo ,name, age , marks) VALUES (? ,?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);

            // Set parameters
            statement.setString(1, rollNo);
            statement.setString(2, name);
            statement.setString(3, age);
            statement.setString(4, marks);
           // RequestDispatcher dispatcher = null;
            // Execute update
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                out.println("<p>Data successfully added!</p>");
                out.println("<a href='main.html'>Back to home.</a>" );
            } else {
                out.println("<p>Error: Unable to add data.</p>");
            }
//            dispatcher.forward(request, response);
        } catch (ClassNotFoundException e) {
           out.println("<p>Error: Unable to load database driver</p>");
            e.printStackTrace();
        }catch (SQLException e) {
            out.println("<p>Error: Database error occurred</p>");
            out.println(e.getMessage());
            e.printStackTrace();
        } 
		
	
	}

}
