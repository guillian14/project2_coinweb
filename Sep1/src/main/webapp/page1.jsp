<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding to cart</title>
</head>
<body>
	<h4>${param.coinName}</h4>
	<h6>${param.coinDesc}</h6>
	<%
	out.println("<img src=\""+request.getParameter("pic")+ "\"' style='width:300px;'>");
	%>
	<h6>Price${param.customerPrice}$</h6>
	<form action="addtocart">
		<input type='hidden' name='pid' value='<%=request.getParameter("pid") %>'/>
		<input type='hidden' name='coinName' value='<%=request.getParameter("coinName")%>'/>
		<input type='hidden' name='coinDesc' value='<%=request.getParameter("coinDesc")%>'/>
		<input type='hidden' name='pic' value='"+<%=request.getParameter("pic")%>+"'/>
		<input type='hidden' name='customerPrice' value='<%=request.getParameter("customerPrice")%>'/>
		<input type='text' name='qtyOrder' value='1'/>
		<button>add to cart</button>
	</form>
</body>
</html>