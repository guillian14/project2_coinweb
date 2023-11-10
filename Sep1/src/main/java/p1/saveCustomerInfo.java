package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class saveCustomerInfo
 */
@WebServlet("/saveCustomerInfo")
public class saveCustomerInfo extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveCustomerInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	 // TODO Auto-generated method stub
	 HttpSession session=request.getSession();
	 session.setAttribute("cID", request.getParameter("customer_ID"));
	 doPost(request, response);
	
	 String name, address, email, cardID;

    name=request.getParameter("customer_name");
    address=request.getParameter("customer_address");
    email=request.getParameter("customer_email");
    cardID=request.getParameter("customer_cardID");
    
    //ArrayList customerInfo=(ArrayList)session.getAttribute("cInfo");
    //PrintWriter out=response.getWriter();
    
    //String cName = (String)session.getAttribute("cName");
    session.setAttribute("cName", name);
    session.setAttribute("cAddress", address);
    session.setAttribute("cEmail", email);
    session.setAttribute("ccardID", cardID);
    
    RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/showcart");
    RequetsDispatcherObj.forward(request, response);
	
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	Connection mycon=null;
	//ResultSet records=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list","root","$Edg131854");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		PreparedStatement preSqlStmt=mycon.prepareStatement("Insert into customers values(?,?,?,?,?)");
		preSqlStmt.setInt(1,Integer.parseInt(request.getParameter("customer_ID"))); //preSqlStmt.setInt(1,orderNo);
		preSqlStmt.setString(2,request.getParameter("customer_name"));
		preSqlStmt.setString(3,request.getParameter("customer_email"));
		preSqlStmt.setString(4,request.getParameter("customer_address"));
		preSqlStmt.setString(5,request.getParameter("customer_cardID"));
		
		int x=preSqlStmt.executeUpdate();
		
		mycon.close();
		if(x>0)
		{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/showcart");
			rd.forward(request, response);
		}
	} catch(Exception e) {e.printStackTrace();} 
}
}