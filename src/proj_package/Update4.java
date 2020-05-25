package proj_package;
import java.sql.*;
import java.io.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Update4
 */
@WebServlet("/Update4")
public class Update4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
       ResultSet rs;
       Statement stmt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update4() {
        super();
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
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/d1","root","abhishek");
		stmt=con.createStatement();
		stmt.executeUpdate("Update student set firstname='"+request.getParameter("fname")+"',lastname='"+request.getParameter("lname")+"',gender='"+request.getParameter("gender")+"',age="+request.getParameter("age")+",branch='"+request.getParameter("branch")+"',semester='"+request.getParameter("semester")+"' where roll_no="+request.getParameter("rollno")+";");
		
		out.print("The Information will be Updated. Redirecting to Homepage");
		response.sendRedirect("Driverhtml.html");
		
		
		
		}
		catch(Exception e) {
			out.println("The Error is "+e);
		}
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
