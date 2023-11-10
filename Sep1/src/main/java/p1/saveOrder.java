package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class saveOrder
 */
@WebServlet("/saveOrder")
public class saveOrder extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveOrder() {
        super();
        // TODO Auto-generated constructor stub
    }
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("order Processing");
	out.println(request.getParameter("customerID"));
	//out.println("update order");
	int x,y=0;
	//session stuff
	HttpSession session=request.getSession();
	ArrayList<row> shoppingCart=(ArrayList<p1.row>) session.getAttribute("sCart");
	if(shoppingCart==null)
		out.println("<p>Empty Shop Cart!</p>");
	else
	{
		//connection stuff
		Connection mycon2=null;
		//Statement s=null;
		//int c=1;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		mycon2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","cba321");
		PreparedStatement insertSQL = mycon2.prepareStatement("insert into order values(?,?,? );");
		//y=s.executeUpdate("Insert into order values ('s','s',3);");
		for(int i=0; i<shoppingCart.size(); i++) {
		insertSQL.setString(1,request.getParameter("customerID").toString()); 
		insertSQL.setString(2,shoppingCart.get(i).getProductID());
		  
		int qtyOrder=shoppingCart.get(i).getQty();
		insertSQL.setInt(3, qtyOrder);
		x=insertSQL.executeUpdate();
		  
		if(x>1) {
			y++;
		}
	}
	mycon2.close();
	} catch (Exception e) {
		
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	for(int i=0; i<shoppingCart.size(); i++) {
		out.println("<br>customer ID "+request.getParameter("customerID").toString()); 
		out.println("<br> product ID "+shoppingCart.get(i).getProductID());
		  
		out.println("<br> product ID "+shoppingCart.get(i).getQty());
	}
	
	out.println("Successfull saving "+y+"records");
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