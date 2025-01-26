package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Statement;

/**
 * Servlet implementation class display
 */
@WebServlet("/delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/first" , "root" , "pokemon");
			PreparedStatement ps = con.prepareStatement("select * from student");
			
			out.print("""
					<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="./style.css" />
  </head>
  <body>
      <style>
      .atag{
         text-decoration: none;
         color: inherit;
      }
    </style>
    <div class="container">
     <nav>
      <div>
        <h3><a href="main.html" class="atag">Tanmay Kanase</a></h3>
        <div>
          <ul>
            <li><button type="button" class="btn btn-primary"> <a href="add.html" class="atag">Add Data</a></button></li>
            <li><button type="button" class="btn btn-secondary">
              <a href="update" class="atag">Update Data</a>
            </button></li>
            <li><button type="button" class="btn btn-danger"> <a href="delete.html" class="atag">Delete Data</a></button></li>
            <li><button type="button" class="btn btn-success"> <a href="display" class="atag">Show Data</a></button></li>
         
          </ul>
        </div>
      </div>
    </nav>
    </div>
    <div class="container">
      <table class="table">
        <thead>
          <tr>
            <th scope="col">Roll No</th>
            <th scope="col">Name</th>
            <th scope="col">Age</th>
            <!-- <th scope="col">Gender</th> -->
            <th scope="col">Marks</th>
            <th scope="col">Result</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
					""");

			
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int totalColumn = rsmd.getColumnCount();
			
			// Table Header
//            out.print("<tr>");
//            for (int i = 1; i <= totalColumn; i++) {
//                out.print("<th>" + rsmd.getColumnName(i) + "</th>");
//            }
//            out.print("</tr>");

            // Table Data
            while (rs.next()) {
                // Assuming newtable has two columns: rollNo and name
                out.print("<tr><td>"  + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getString(6) +"</td><td>"+"<button type=\"button\" class=\"btn btn-secondary\">\r\n"
                		+ "              <a href=\"delete.html?rollNo=" + rs.getString(1)+"\" class=\"atag\">Delete Data</a>\r\n"
                		+ "            </button>"+"</td></tr>");
            }
            out.print("""
            		</tbody>
      </table>
    </div>
  </body>
</html>
            		""");

			
			
			
			
		}catch(SQLException e) {
			out.print("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String rollNo = request.getParameter("rollNo");

        PrintWriter out = response.getWriter();
        
        
        try {
            // Load JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?useSSL=false", "root", "pokemon");

            // SQL Insert query
            String query = "Delete FROM student where rollNo = ?";
            PreparedStatement statement = conn.prepareStatement(query);

            // Set parameters
            statement.setString(1, rollNo);
           // RequestDispatcher dispatcher = null;
            // Execute update
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                out.println("<p>Data deleted successfull</p>");
                out.println("<a href='main.html'>Back to home.</a>" );
            } else {
                out.println("<p>Error: Unable to delete data.</p>");
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
