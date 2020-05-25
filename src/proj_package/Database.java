package proj_package;
import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Database
 */
@WebServlet("/Database")
public class Database extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 Connection con;
	    Statement stmt;
	    ResultSet rs;
    /**
     * Default constructor. 
     */
    public Database() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try {
			HttpSession session=request.getSession(false);
			if(session!=null) {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/d1","root","abhishek");
			stmt=con.createStatement();
			rs=stmt.executeQuery("Select * from student");
			
			out.print("<table border=1 width=60%>");
			out.print("<tr>"
					+ "<th>First Name</th>"
					+ "<th>Last Name</th>"
					+"<th>Gender</th>"
					+ "<th>Roll number</th>"
					+ "<th>Age</th>"
					+ "<th>Branch</th>"
					+ "<th>Semester</th>"
					+ "</tr>");
			out.print("<tr>");
			while(rs.next())
			{
				out.print("<tr>");
				out.print("<td>"+rs.getString(1)+"</td>");
				out.print("<td>"+rs.getString(2)+"</td>");
				out.print("<td>"+rs.getString(3)+"</td>");
				out.print("<td>"+rs.getInt(4)+"</td>");
				out.print("<td>"+rs.getInt(5)+"</td>");
				out.print("<td>"+rs.getString(6)+"</td>");
				out.print("<td>"+rs.getString(7)+"</td>");
				out.print("</tr>");
			}
		}else out.print("Error Occured");
		}
		catch(Exception e) {out.print("Error is :"+e);}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
