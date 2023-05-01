

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servler_curd1.Dao;
import com.servler_curd1.Data;

@WebServlet("/Register_Action")
public class Register_Action extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String Firstname=request.getParameter("fn");
			String Lastname=request.getParameter("ln");
			String Email=request.getParameter("em");
			String Userid=request.getParameter("uid");
			String Password=request.getParameter("pa");
			String Stdcode=request.getParameter("std");
			String Phoneno=request.getParameter("ph");
			String Gender=request.getParameter("gn");
			
			PrintWriter out=response.getWriter();
			
			Data d=new Data();
			d.setFirstname(Firstname);
			d.setLastname(Lastname);
			d.setEmail(Email);
			d.setUserid(Userid);
			d.setPassword(Password);
			d.setStcode(Stdcode);
			d.setPhoneno(Phoneno);
			d.setGender(Gender);
			
			Dao s=new Dao();
			int i=s.register_logic(d);
			out.println("<html>");
			out.println("<center><h1>");
			out.println("Student Registered Sucessfully		:"+i+"</br>");
			out.println("Registernation Number	:"+Userid+"</br>");
			out.println("Password				:"+Password+"</br>");
			out.println("</h1></center>");
			out.println("</html>");

			
	}
}
