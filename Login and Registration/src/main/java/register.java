

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public register() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		int roll=Integer.parseInt(request.getParameter("roll"));
		String pass=request.getParameter("password");
		String name=request.getParameter("myname");
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("add");
		String classnm=request.getParameter("class");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wt","root","root");
			Statement st=con.createStatement();
			st.executeUpdate("insert into defstudent values ('"+roll+"', '"+pass+"', '"+name+"','"+mobile+"','"+address+"','"+classnm+"');");
			out.println("Registration Success<br/><br/>");
			out.println("<a href=\"index.html\">Home</a>");
		}
		catch(Exception e)
		{
			out.println(e);
		}
		out.println("</body></html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
