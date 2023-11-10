package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Orders
 */
@WebServlet("/Orders")
public class Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Orders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out2=response.getWriter();
		
		//for Orders sql table info
		Connection mycon=null; 
        Statement sql_stmt=null;
        ResultSet records=null;
        
        //for Customers sql table info
        Statement sql_stmt2=null;
        ResultSet records2=null;
		
        //for product sql table info
        Statement sql_stmt3=null;
        ResultSet records3=null;
        
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list","root","$Edg131854");
            sql_stmt = mycon.createStatement();  
            records = sql_stmt.executeQuery("select * from orders");
            
            sql_stmt2 = mycon.createStatement();
            sql_stmt3 = mycon.createStatement();
		    
		    //checks if sql orders table is empty, otherwise continue
            if(!records.isBeforeFirst()) {
            	out2.println("<html><head></head><body style=\"background-color:#99ccff;\">");
            	out2.println("<p>No orders at the moment!</p><br/><br/>");
            	out2.println("<form action='admin.html'>");
				out2.println("<button>Back to Admin Menu</button>");
				out2.println("</form>");
            }
            
            else {
	            out2.println("<html><head><title>Orders</title></head><body style=\"background-color:#99ccff;\">");
	            out2.print("<h1>" + "Customer Orders" + "</h1>");
	            out2.println("<table border='1' width='100%' cellpadding='6'>");            
	            out2.println("<tr>");
	            out2.println("<th>Customer Info</th>");
	            out2.println("<th>Products Ordered</th>");
	            out2.println("<th>Address</th>");
	            out2.println("<th>Customer Card Info</th>");
	            
	            
	            //for two sql statement commands
	            String batch1; 
	            String batch2;

	            
	            
	            while (records.next()) {
	            	
	            	out2.println("<form action='page4.jsp' method='post'>");
	            	out2.print("<tr>");
	            	
	            	//for sql orders table
	            	String arr = records.getString("productsOrdered");
	            	String[] products = arr.split("[,]");
	            	
	            	String arr2 = records.getString("productQtys");
	            	String[] quantity = arr2.split("[,]");

	            	for (int i = 0; i < products.length; i++) {
	            		batch2 = "select * from products where pid="+products[i]; //finds the row of information in products by customer id
	            		records3 = sql_stmt3.executeQuery(batch2);
	            		records3.next();
	            		
	            		out2.println("<input type='hidden' name='pid' value='"+records3.getString("pid")+"'>");
	            		out2.println("<input type='hidden' name='coinName' value='"+records3.getString("name")+"'>");
	            		out2.println("<input type='hidden' name='coinDesc' value='"+records3.getString("description")+"'>");
	            		out2.println("<input type='hidden' name='price' value='"+records3.getString("price")+"'>");
	            		out2.println("<input type='hidden' name='pic' value='"+records3.getString("image")+"'>");
	            		out2.println("<input type='hidden' name='qty' value='"+ quantity[i]+"'/>");
	            	}
	            	
	            	
	            	//for customers table to get customer information
	            	batch1 = "select * from customers where customerID="+records.getString("customerID");
	            	records2 = sql_stmt2.executeQuery(batch1);
	            	records2.next();
	            	
	            	out2.print("<td>"+"<button>"+"name: "+records2.getString("customerName")+"</button>"+"<br/>"+"<br/>");
	            	out2.println("Customer ID: "+records.getString("customerID")+"<br/>");
	                out2.print(records2.getString("customerEmail")+"</td>");
	            	
	                
	            	out2.println("<td>"+"Products ordered: "+records.getString("productsOrdered")+"</p"+"<br/>");
	                out2.println("<br/>"+"Quantities: "+records.getString("productQtys")+"</td>");
	                
	                out2.print("<td>"+records2.getString("customerAddress")+"</td>");
	                
	                out2.print("<td>"+records2.getString("customerCardID")+"</td>");
	                out2.print("</tr>");
	            	
	                
	                out2.println("<input type='hidden' name='id' value='"+records.getString("customerID")+"'/>");
	                out2.println("<input type='hidden' name='products' value='"+records.getString("productsOrdered")+"'/>");
	                out2.println("<input type='hidden' name='status' value='"+records.getString("status")+"'/>");
	                
	                out2.println("<input type='hidden' name='customerName' value='"+records2.getString("customerName")+"'/>");
	                out2.println("<input type='hidden' name='email' value='"+ records2.getString("customerEmail")+"'/>");
	                out2.println("<input type='hidden' name='address' value='"+records2.getString("customerAddress")+"'/>");
	                out2.println("<input type='hidden' name='cardInfo' value='"+records2.getString("customerCardID")+"'/>");
	                
	                
	                out2.println("</form>");
	            }
            }
            
        out2.print("</table>");
        
        out2.print("<br/><br/>");
        out2.println("<form action='admin.html'>");
        out2.println("<button>Back to Admin Menu"); 
        out2.println("</form>");
		}
        
        
        
        catch(Exception e) {
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
