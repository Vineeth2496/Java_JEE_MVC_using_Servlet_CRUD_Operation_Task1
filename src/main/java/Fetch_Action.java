

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servler_curd1.Dao;
import com.servler_curd1.Data;

@WebServlet("/Fetch_Action")
public class Fetch_Action extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession hs=request.getSession(false);
		PrintWriter out=response.getWriter();
		
		if(hs!=null)
		{
			String userid=(String) hs.getAttribute("userid");
			String password=(String) hs.getAttribute("password");
			
			Data d=new Data();
			d.setUserid(userid);
			d.setPassword(password);
			
			
			List<Data> list=Dao.profile_logics(d);
			
			out.println("<html>");
			out.println("<body>");
			out.println("<center>");
			out.print("<table border=3>");
			out.print("<div>");
			out.print("<tr>");
			out.print("<th>"+"First Name"+"</th>");
			out.print("<th>"+"Last Name"+"</th>");
			out.print("<th>"+"Email"+"</th>");
			out.print("<th>"+"Userid"+"</th>");
			out.print("<th>"+"Password"+"</th>");
			out.print("<th>"+"Stdcode"+"</th>");
			out.print("<th>"+"Phone No"+"</th>");
			out.print("<th>"+"Gender"+"</th>");
			out.print("<th>"+"Edit Profile"+"</th>");
			out.print("<th>"+"Delete Profile"+"</th>");
			out.print("</tr>");
			
			for(Data d1 :list)
			{
						
				out.print("<tr>");
				out.print("<td>"+ d1.getFirstname()+"</td>");
				out.print("<td>"+ d1.getLastname()+"</td>");
				out.print("<td>"+ d1.getEmail()+"</td>");
				out.print("<td>"+ d1.getUserid()+"</td>");
				out.print("<td>"+ d1.getPassword()+"</td>");
				out.print("<td>"+ d1.getStcode()+"</td>");
				out.print("<td>"+ d1.getPhoneno()+"</td>");
				out.print("<td>"+ d1.getGender()+"</td>");
				
				out.print("<td>"+"<a href='Edit_return.jsp?Userid="+ d1.getUserid()+"'>Edit</a>"+"</td>");
				out.print("<td>"+"<a href='Delete.jsp?Userid="+d1.getUserid()+"'>Delete</a>"+"</td>");
				out.print("</tr>");
			}
			
		out.print("</div>");
		out.println("</table></br></br>");
		out.println("<font style='color: green;'><a href='End_Action'>Logout</a></font>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		}
		else
		{
			out.println("<html>");
			out.println("<center>");
			out.println("Account does not exsits with your Username & Password");
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
			out.println("</center>");
			out.println("</html>");
		}
		
	}
}
