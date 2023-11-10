<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editing Coin</title>
</head>
<body style="background-color:#99ccff;">
	<h4 style="font-size:20pt; font-family:Sans-serif;">${param.coinName}</h4>
	<h6 style="font-size:13pt; font-family:Sans-serif;">${param.coinDesc}</h6>
	<%
	out.println("<img src=\""+request.getParameter("pic")+ "\"' style='width:300px;'>");
	%>
	<h6 style="font-size:10pt; font-family:Sans-serif;">Price: ${param.customerPrice}$</h6>
	
	<form action="editInventory">
		<h2 style="font-size:10pt; font-family:Sans-serif;">
		product ID<br/><input type='number' name='pid' value='<%=request.getParameter("pid") %>'/> <br/><br/>
		Coin Name<br/><input type='text' size='50' name='coinName' value='<%=request.getParameter("coinName")%>'/> <br/><br/>
		
		Coin Description <br/>
		<textarea rows='5' cols='50' name='coinDesc'><%=request.getParameter("coinDesc")%> </textarea> <br/><br/>
		
		Image<br/>
		<input type='text' name='pic' size='50' value='<%=request.getParameter("pic")%>'/> <br/>
		
		price<br/>
		<input type='number' name='customerPrice' value='<%=request.getParameter("customerPrice")%>'/> <br/>
		
		<input type='hidden' name='edit' value='modify'> <br/> <br/> 
		<button>update coin</button>
		</h2>
	</form>
	<br />
	<br />
	<p><b> OR </b></p> <br />
	
	<form action="editInventory">
		<input type='hidden' name='edit' value='delete'>
		<input type='hidden' name='pid' value='<%=request.getParameter("pid") %>'/> <br/>
		<button>Delete Coin</button>
	</form>
	
</body>
</html>


