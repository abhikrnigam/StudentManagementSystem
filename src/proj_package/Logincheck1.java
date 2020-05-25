package proj_package;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;
/**
 * Servlet implementation class Logincheck1
 */
@WebServlet("/Logincheck1")
public class Logincheck1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;
	Statement stmt;
	ResultSet rs;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logincheck1() {
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
		try{
			HttpSession session=request.getSession();
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/d1","root","abhishek");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from logindata where username='"+request.getParameter("username")+"' AND password ='"+request.getParameter("password")+"';");
			if(rs.next()) {
				session.setAttribute("user", request.getParameter("username"));
				response.sendRedirect("Driverhtml.html");
			}
			else {
				out.print("The Combination of Password and Username is Wrong");
				out.print("Click here to go back <a href='homepage.html'>Go Back</a>");
			}
			
		}
	catch(Exception e) {
		
		out.print("The error is "+e);
		
		
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
