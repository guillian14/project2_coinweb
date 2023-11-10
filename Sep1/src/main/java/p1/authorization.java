package p1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class authorization
 */
@WebServlet("/authorization")
public class authorization extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public authorization() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String user = String.valueOf(request.getParameter("user"));
		String pwd = String.valueOf(request.getParameter("pwd"));
		
		if (user.equals("admin") && pwd.equals("admin")) {
			response.sendRedirect("admin.html");
		}
		else {
			out.println("<html><head></head><body style=\"background-color:#99ccff;\">");
			out.println("Wrong Username or Password"+"<br>");
			out.println("<form action='page5.jsp'>");
			out.println("<button>Back to Sign in</button>");
			out.println("</form>");
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
