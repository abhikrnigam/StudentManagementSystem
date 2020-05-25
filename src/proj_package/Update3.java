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
 * Servlet implementation class Update3
 */
@WebServlet("/Update3")
public class Update3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
       ResultSet rs;
       Statement stmt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update3() {
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
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/d1","root","abhishek");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from student");
			if(rs.next()) {*/
				out.print("<form action='Update4'><fieldset>");
				out.print("<strong>Please Enter the Updated Values</strong><br><br>");
				
				out.print("Enter Your Roll no.(original)<input type='text' name='rollno'><br><br>");
				
				out.print("First Name is :<input type='text' value='' name='fname'><br><br>");
				out.print("Last Name is :<input type='text' value='' name='lname'><br><br>");
				out.print("Gender is :<input type='text' value='' name='gender'><br><br>");
				//out.print("Roll no is :<input type='text' value=''>");
				out.print("Age is:<input type='text' value='' name='age'><br><br>");
				out.print("Branch is:<input type='text' value='' name='branch'><br><br>");
				out.print("Semester is:<input type='text' value='' name='semester'><br><br>");
				out.print("<input type='submit' value='Update!'>");
				out.print("</fieldset></form>");
			/*}
			else System.out.println("The Record does not Exist");
		}
		catch(Exception e){
			System.out.println("The error is "+e);
		}*/
	
	
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
