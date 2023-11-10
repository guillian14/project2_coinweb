package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class showShopCart
 */
@WebServlet("/showcart")
public class showcart extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showcart() {
        super();
        // TODO Auto-generated constructor stub
    }
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub
	response.setContentType("text/html");
	PrintWriter out2=response.getWriter();
	out2.println("<html><head><title>Shopping Cart</title></head><style>\r\n"
    		+ ".center {\r\n"
    		+ "position: relative;\r\n"
    		+ "text-align: center;\r\n"
    		+ "margin-left: auto\r\n"
    		+ "margin-right: auto;\r\n"
    		+ "}\r\n"
    		+ "</style><body>");
	
	out2.print("<h1 style=\"text-align:center\">" + "CoinCrafters Tech" + "</h1>");
    out2.print("<h2 style=\"text-align:center\">" + "Shopping Cart" + "</h2>");
    
    out2.println("<div class=\"center\">");
	
	HttpSession session=request.getSession();
	ArrayList<row> shopCart=(ArrayList)session.getAttribute("sCart");
	
	if(shopCart==null)
		out2.println("<p>Empty Shop Cart!</p>");
	else
	{
		out2.println("<form action=\"ecom_customerInfo.jsp\" >");
        out2.println("<button>Enter Customer Info</button>");
        out2.println("</form>");
        
        if ((String)session.getAttribute("cID") != null) {
        	out2.println("<form action=\"ecom_checkout\" >");
	        out2.println("<button>Checkout Cart</button>");
	        out2.println("</form>");
        }
        
		out2.println("<table border='1' width='100%' cellpadding='6'>");
		out2.println("<tr>");
		//out2.println("<th>&nbsp</th>");
		//out2.println("<th>Product ID</th>");
		out2.println("<th>Product Name</th>");
		out2.println("<th>Picture</th>");
		out2.println("<th>Product Description</th>");
		out2.println("<th>Price</th>");
		out2.println("<th>Quantity</th>");
		out2.println("</tr>");
		for(row r:shopCart) {
			out2.println("<tr>");
			out2.println("<td>"+r.get_product_name()+"</td>");
			out2.println("<td>"+"<img src=\"" + r.get_image() + "\" style=\"width:200px\">"+"</td>");
			out2.println("<td>"+r.get_product_desc()+"</td>");
			out2.println("<td>"+"$"+r.get_product_price()+"</td>");
			out2.println("<td>"+r.get_qty()+"</td>");
			out2.println("</tr>");
		}
	}
	out2.println("</table><br />");
	
	out2.println("<form action=\"Home.html\" >");
    out2.println("<button>Return Home</button>");
    out2.println("</form>");
	
    out2.println("<form action=\"productslist\" >");
    out2.println("<p><button>Return to Product List</button></p>");
    out2.println("</form>");
    
	out2.println("</div>");
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}
}
