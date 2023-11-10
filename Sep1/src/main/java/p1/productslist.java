package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ecom_productslist
 */
@WebServlet("/productslist")
public class productslist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productslist() {
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
        //initializing the database connection
        Connection mycon=null;
        Statement sql_stmt=null;
        ResultSet records=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_list","root","$Edg131854");
            sql_stmt = mycon.createStatement();  
            records = sql_stmt.executeQuery("select * from products");
            
            out2.println("<html><head><title>Product List</title></head><style>\r\n"
            		+ ".center {\r\n"
            		+ "position: relative;\r\n"
            		+ "text-align: center;\r\n"
            		+ "margin-left: auto\r\n"
            		+ "margin-right: auto;\r\n"
            		+ "}\r\n"
            		+ "</style><body>");
            
            out2.print("<h1 style=\"text-align:center\">" + "CoinCrafters Tech" + "</h1>");
            out2.print("<h2 style=\"text-align:center\">" + "Products List" + "</h2>");
            
            out2.println("<div class=\"center\">");
            out2.println("<form action=\"Home.html\" >");
            out2.println("<button>Return Home</button>");
            out2.println("</form>");
	    	
            out2.println("<form action=\"showcart\" >");
            out2.println("<p><button>Open Cart</button></p>");
            out2.println("</form>");
            out2.println("</div>");
	    	
            out2.println("<table border='1' width='100%' cellpadding='6'>");
            
            out2.println("<tr>");
            out2.println("<th>Picture</th>");
            out2.println("<th>Product Name</th>");
            out2.println("<th>Product Description</th>");
            out2.println("<th>Price</th>");
            out2.println("<th>Number in Stock</th>");
            
            out2.println("</tr>");
            
            while (records.next()) {
            	out2.print("<tr>");
            	out2.println("<td>"+"<img src=\""+records.getString("image")+ "\" style=\"width:200px\">"+"</td>");
                out2.print("<td>"+records.getString("name")+"</td>");
                out2.print("<td>"+records.getString("description")+"</td>");
                out2.print("<td>"+"$"+records.getString("price")+"</td>");
                out2.print("<td>"+records.getString("qty_available")+"</td>");
        		out2.println("<form action='ecom_productPage.jsp' method='post'>");
        		//out2.println("<td></td>");
        		out2.println("<input type='hidden' name='product_id' value='"+records.getString("pid")+"'/>");
        		out2.println("<input type='hidden' name='product_name' value='"+ records.getString("name") +"'/>");
        		out2.println("<input type='hidden' name='product_description' value='"+records.getString("description")+"'/>");
        		out2.println("<input type='hidden' name='image' value='"+ records.getString("image") +"'/>");
        		out2.println("<input type='hidden' name='product_price' value='"+records.getString("price")+"'/>");
        		out2.println("<input type='hidden' name='qty' value='1'/>");
        		out2.println("<input type='hidden' name='product_qty_available' value='"+records.getString("qty_available")+"'/>");
        		out2.println("<td>"+"<button>Buy now</button>"+"</td>");
        		out2.println("</tr>");
        		out2.println("</form>");
            }
            out2.print("</table>");
        }
        
        
        
        catch(Exception e) {e.printStackTrace();
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