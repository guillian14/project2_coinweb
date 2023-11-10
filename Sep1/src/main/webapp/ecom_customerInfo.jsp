<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Customer Info</title>
		<style>
		.center {
		position: relative;
		text-align: center;
		margin-left: auto;
		margin-right: auto;
		}
		</style>
	</head>
	<body>
	
		<div class="center">
		<h1 style="text-align:center">CoinCrafters Tech</h1>
		<h2 style="text-align:center">Please enter customer information:</h2>
	
		<form action="saveCustomerInfo">
			<h3>Customer ID:</h3>
			<input type='text' name='customer_ID'/>
			</br>
			<h3>Name:</h3>
			<input type='text' name='customer_name'/>
			</br>
			<h3>Email:</h3>
			<input type='text' name='customer_email'/>
			</br>
			<h3>Address:</h3>
			<input type='text' name='customer_address'/>
			</br>
			<h3>Card ID:</h3>
			<input type='text' name='customer_cardID'/>
			</br></br>
			<button>Enter Information</button>
		</form>
		</div>
	</body>
</html>