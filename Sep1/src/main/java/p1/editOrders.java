package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editOrders
 */
@WebServlet("/editOrders")
public class editOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection mycon2=null;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		String status = String.valueOf(request.getParameter("status"));
		int id = Integer.valueOf(request.getParameter("id"));
		
		int x;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			mycon2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list","root","$Edg131854"); 
			
			PreparedStatement stmt = mycon2.prepareStatement("update orders set status=? where customerID=?");
			stmt.setString(1, status);
			stmt.setInt(2, id);
			x=stmt.executeUpdate();
			
			if(x>0) {
				out.println("<html><head></head><body style=\"background-color:#99ccff;\">");
				out.println("succesfully updated the status");
				out.println("<form action='Orders'>");
				out.println("<button>Back to Edit Customer Orders</button>");
				out.println("</form>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
