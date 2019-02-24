package sobi.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String pass=request.getParameter("psw");
		
		if((uname.equals("sobiadmin")&& pass.equals("admin123"))
				||(uname.equals("developer")&& pass.equals("dev2019")))
		{
			HttpSession session=request.getSession();
			session.setAttribute("username", uname);
			response.sendRedirect("SOBI_Home.jsp");
		}
		else
		{
			HttpSession session=request.getSession();
			session.setAttribute("err_msg", "invalid username or password");
			response.sendRedirect("index.jsp");
		}
		
		
	}

}
