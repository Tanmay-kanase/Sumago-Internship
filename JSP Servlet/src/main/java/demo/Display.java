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
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
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
    <link rel="stylesheet" href="./style.css" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <body>
  <div class="container">
     <nav>
      <div>
        <h3><a href="main.html" class="atag">Tanmay Kanase</a></h3>
        <div>
          <ul>
            <li><button type="button" class="btn btn-primary"> <a href="add.html" class="atag">Add Data</a></button></li>
            <li><button type="button" class="btn btn-secondary">
              <a href="Update" class="atag">Update Data</a>
            </button></li>
            <li><button type="button" class="btn btn-danger"> <a href="delete.html" class="atag">Delete Data</a></button></li>
            <li><button type="button" class="btn btn-success"> <a href="Display" class="atag">Show Data</a></button></li>
         
          </ul>
        </div>
      </div>
    </nav>
    </div>
    
</div>
    <form action="Display" method="post">
   <div class="input-group mb-3 container">
  <input type="text" class="form-control" id="name" name="name" placeholder="Search By Name ... " aria-label="Recipient's username" aria-describedby="button-addon2">
  <select class="form-select" aria-label="Default select example" name="sortBy">
  <option selected>Sort by</option>
  <option value="age">Age</option>
  <option value="marks">Marks</option>
  <option value="rollNo">RollNo</option>
  </select>
  <select class="form-select" aria-label="Default select example" name="orderby">
  <option selected>Order</option>
  <option value="asc">Ascending</option>
  <option value="desc">Descending</option>
</select>

  <button class="btn btn-success" type="submit" id="button-addon2">Search</button>
</form>
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
                out.print("<tr><td>"  + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getString(6) + "</td></tr>");
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
		String name = request.getParameter("name");
		String sortBy = request.getParameter("sortBy"); // Get sort criteria
	    String order = request.getParameter("order"); 
		PrintWriter out = response.getWriter();
		
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
		
		try {
            // Load JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to the database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?useSSL=false", "root", "pokemon");
            
            if (sortBy == null) {
                sortBy = "rollNo";
            }
            if (order == null ) {
                order = "asc"; 
            }

            // SQL Insert query
            if(name == null || name.trim().isEmpty()) {
            	String query = "SELECT * FROM student ";
            	ps = conn.prepareStatement(query);
            }else {
            String query = "SELECT * FROM student WHERE name LIKE ? ORDER BY " + sortBy + " " + order;
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + name + "%");
            }
            
					

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
    <link rel="stylesheet" href="./style.css" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
  </head>
  <body>
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
    
</div>
    <form action="Display" method="post">
   <div class="input-group mb-3 container">
  <input type="text" class="form-control" id="name" name="name" placeholder="Search By Name ... " aria-label="Recipient's username" aria-describedby="button-addon2">
   <select class="form-select" aria-label="Default select example" name="sortBy">
  <option selected>Sort by</option>
  <option value="age">Age</option>
  <option value="marks">Marks</option>
  <option value="rollNo">RollNo</option>
  </select>
  <select class="form-select" aria-label="Default select example" name="order">
  <option selected>Order</option>
  <option value="asc">Ascending</option>
  <option value="desc">Descending</option>
</select>
  <button class="btn btn-success" type="submit" id="button-addon2">Search</button>
</form>
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
          </tr>
        </thead>
        <tbody>
					""");
            // Set parameters
            boolean hasResults = false;
            
            
            rs = ps.executeQuery();
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("Expires", 0);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int totalColumn = rsmd.getColumnCount();
           // RequestDispatcher dispatcher = null;
            // Execute update
			while (rs.next()) {
                // Assuming newtable has two columns: rollNo and name
				hasResults = true;
                out.print("<tr><td>"  + rs.getString(2) + "</td><td>" + rs.getString(3) + "</td><td>" + rs.getString(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getString(6) + "</td></tr>");
            }
			if (!hasResults) {
	            out.print("<tr><td colspan='5' class='text-center'>No results found for '" + name + "'</td></tr>");
	        }
            out.print("""
            		</tbody>
      </table>
    </div>
  </body>
</html>
            		""");
            int rowsInserted = ps.executeUpdate();
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
//            out.println("<p>Error: Database error occurred</p>");
//            out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
		
	}

}
