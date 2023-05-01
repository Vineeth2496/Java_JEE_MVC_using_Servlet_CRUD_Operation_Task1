

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class End_Action extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession hs=request.getSession();
		hs.invalidate();
		PrintWriter out=response.getWriter();

		out.println("<html>");
		out.println("<center>");
		out.println("Successfully Logged Out");
		// re direct to login(ui)
		RequestDispatcher  rd=request.getRequestDispatcher("Login.jsp");
		rd.include(request, response);
		out.println("</html>");
		out.println("</center>");

		
	}

}
