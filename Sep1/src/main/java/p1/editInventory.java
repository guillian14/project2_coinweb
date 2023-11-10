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

//public java.lang.String getParameter(java.lang.string name);
/**
 * Servlet implementation class updateStudentTable
 */
@WebServlet("/editInventory")
public class editInventory extends HttpServlet {
private static final long serialVersionUID = 1L;
       
 
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	Connection mycon2=null;
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	
	
	String edit = String.valueOf(request.getParameter("edit"));
	
	int x;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	try {
		mycon2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list","root","$Edg131854");
		String addData = "insert into products (pid, name, description, price, image)" + "values (?, ?, ?, ?, ?)";
		String updateData = "update products set name=?, description=?, price=?, image=? where pid=?";
		
		PreparedStatement addStmt = mycon2.prepareStatement(addData);
		PreparedStatement deleteStmt = mycon2.prepareStatement("Delete From products where pid=?");
		PreparedStatement updateStmt = mycon2.prepareStatement(updateData);
		
		if(edit.equals("add")) {
			addStmt.setInt(1, Integer.valueOf(request.getParameter("pid")));
			addStmt.setString(2, String.valueOf(request.getParameter("coinName")));
			addStmt.setString(3, String.valueOf(request.getParameter("coinDesc")));
			addStmt.setFloat(4, Float.valueOf(request.getParameter("customerPrice")));
			addStmt.setString(5, String.valueOf(request.getParameter("pic")));
			x=addStmt.executeUpdate();
			
			if(x>0) {
				out.println("<html><head></head><body style=\"background-color:#99ccff;\">");
				out.println("succesfully updated the coins table");
				out.println("<form action='Inventory'>");
				out.println("<button>Back to Edit Coins</button>");
				out.println("</form>");
				
			}
			
			
		} else if(edit.equals("modify")) {
		
			updateStmt.setString(1, String.valueOf(request.getParameter("coinName")));
			updateStmt.setString(2, String.valueOf(request.getParameter("coinDesc")));
			updateStmt.setFloat(3, Float.valueOf(request.getParameter("customerPrice")));
			updateStmt.setString(4, String.valueOf(request.getParameter("pic")));
			updateStmt.setInt(5, Integer.valueOf(request.getParameter("pid")));
			x=updateStmt.executeUpdate();
		
			if(x>0) {
				out.println("<html><head></head><body style=\"background-color:#99ccff;\">");
				out.println("succesfully updated the coins table");
				out.println("<form action='Inventory'>");
				out.println("<button>Back to Edit Coins</button>");
				out.println("</form>");
				
			}
			
			
		} else if(edit.equals("delete")) {
			
			deleteStmt.setInt(1,Integer.valueOf(request.getParameter("pid")));
			x=deleteStmt.executeUpdate();
			if(x>0) {
				out.println("<html><head></head><body style=\"background-color:#99ccff;\">");
				out.println("succesfully updated the coins table");
				out.println("<form action='Inventory'>");
				out.println("<button>Back to Edit Coins</button>");
				out.println("</form>");
				
			}
			
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