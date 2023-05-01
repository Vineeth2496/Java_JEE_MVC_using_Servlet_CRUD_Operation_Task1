

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servler_curd1.Dao;

@WebServlet("/Login_Action")
public class Login_Action extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	String uid=request.getParameter("uid");
	String pass=request.getParameter("pa");
	
	HttpSession hs=request.getSession();
	
	PrintWriter out=response.getWriter();
	
	Dao s=new Dao();
	Vector v=s.login_logics();
	
	if(v.contains(uid)&&v.contains(pass))
	{
		hs.setAttribute("userid", uid);
		hs.setAttribute("password", pass);
		RequestDispatcher rd=request.getRequestDispatcher("Fetch_Action");
		rd.forward(request, response);
	}
	else {
		out.println("<html>");
	//	out.println("<body style="color:white;">");
		out.println("<center>");
		out.println("Invalid Username or Password" );
		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		rd.include(request, response);
		out.println("</center>");
	//	out.println("</body>");
		out.println("</html>");
	}
	}

}
