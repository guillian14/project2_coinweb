package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ecom_checkout
 */
@WebServlet("/ecom_checkout")
public class ecom_checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ecom_checkout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Connection mycon=null;
		ArrayList<row> shopCart=(ArrayList)session.getAttribute("sCart");
		
		String product_ID_string = new String("");
		String product_qty_string = new String("");
		
		for(row r:shopCart) {
			product_ID_string = product_ID_string + r.get_product_id() + ",";
			product_qty_string = product_qty_string + r.get_qty() + ",";
		}

		product_ID_string = product_ID_string.substring(0, product_qty_string.length() - 1);
		product_qty_string = product_qty_string.substring(0, product_qty_string.length() - 1);
		
		//ResultSet records=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list","root","$Edg131854");
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			
			PreparedStatement preSqlStmt=mycon.prepareStatement("Insert into orders values(?,?,?, ?)");
			preSqlStmt.setInt(1,Integer.parseInt((String)session.getAttribute("cID"))); //preSqlStmt.setInt(1,orderNo);
			preSqlStmt.setString(2,product_ID_string);
			preSqlStmt.setString(3,product_qty_string);
			preSqlStmt.setString(4,"Ordered");
			
			int x=preSqlStmt.executeUpdate();
			mycon.close();
			if(x>0)
			{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Home.html");
				rd.forward(request, response);
			}
		} catch(Exception e) {e.printStackTrace();} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
