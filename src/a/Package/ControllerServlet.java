package a.Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uName = request.getParameter("name");
		String uPassword = request.getParameter("password");
		
		anBean bonanza=new anBean();
		
		bonanza.setName(uName);
		bonanza.setPassword(uPassword);
		request.setAttribute("bean", bonanza);
		
		boolean status = bonanza.validate();
			try {	
				if (status) {
					Cookie chocolateChip = new Cookie("username", uName);
					chocolateChip.setMaxAge(180);
					response.addCookie(chocolateChip);
					
					RequestDispatcher rd=request.getRequestDispatcher("login-success.jsp");
					rd.forward(request, response);
				} else {
					RequestDispatcher rd=request.getRequestDispatcher("login-error.jsp");
					rd.forward(request, response);
				}
		}catch (Exception e) {
			System.out.println(e);
		}		
	
	}

}
