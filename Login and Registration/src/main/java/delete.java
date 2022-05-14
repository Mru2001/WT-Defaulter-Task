

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		int roll=Integer.parseInt(request.getParameter("roll"));
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wt","root","root");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from defstudent where roll='"+roll+"';");
			if(rs.next())
			{
				st.executeUpdate("delete from defstudent where roll='"+roll+"';");
				out.println("Deletion Success <br/>Deleted Roll No: "+roll+"<br/><br/>");
				out.println("<a href=\"index.html\">Home</a>");
			}
			else
			{
				out.println("User does not exist<br/><br/>");
				out.println("<a href=\"index.html\">Home</a>");
			}
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
