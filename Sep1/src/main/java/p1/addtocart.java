package p1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class addToShopCart
 */
@WebServlet("/addtocart")
public class addtocart extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocart() {
        super();
        // TODO Auto-generated constructor stub
    }
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
	HttpSession session=request.getSession();
    ArrayList<row> shopCart=(ArrayList)session.getAttribute("sCart");
    PrintWriter out=response.getWriter();
    if (shopCart == null) {
	    shopCart = new ArrayList();
	    session.setAttribute("sCart", shopCart);
    }
    String name, desc, image, id;
    float price;
    int qty, qty_available;
    id=request.getParameter("product_id");
    name=request.getParameter("product_name");
    desc=request.getParameter("product_description");
    image=request.getParameter("image");
    price=Float.parseFloat(request.getParameter("product_price"));
    qty=Integer.parseInt(request.getParameter("qty"));
    qty_available=Integer.parseInt(request.getParameter("product_qty_available"));
    
    
    row Item=new row(id, name, desc, image, qty, price, qty_available);
    shopCart.add(Item);
    session.setAttribute("sCart", shopCart);
    RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/showcart");
    RequetsDispatcherObj.forward(request, response);
    
     
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
doGet(request, response);
}
}