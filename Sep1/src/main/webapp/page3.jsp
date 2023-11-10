<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding Coin</title>
</head>
<body style="background-color:#99ccff;">
	
	<h1 style="font-size:20pt; font-family:Sans-serif;">New Coin</h1>
	
	<form action="editInventory">
	<h2 style="font-size:15pt; font-family:Sans-serif;">
		Product ID <br/>
		<input type='number' name='pid' placeholder='e.g. 11'/> <br/> 
		
		Coin Name <br>
		<input type='text' size='50' name='coinName' placeholder='e.g. 1732 Mexico 8 Reales'/>  <br/> <br/>
		
		Coin Description <br/>
		<textarea rows='5' cols='50' name='coinDesc'> </textarea> <br/> <br/>
		
		Image <br/>
		<input type='file' name='pic' accept='image/png, image/jpeg, image/jpg'/>  <br/><br/>
		
		price <br/>
		<input type='number' name='customerPrice' placeholder='e.g. 10000'/>  <br/><br/>
		
		<input type='hidden' name='edit' value='add'>
		<button>add coin</button>
		</h2>
	</form>
	
	<br/><br/>
	
	<form action="Inventory" >
	<button>Back to Edit Coins</button>
	</form>
	
</body>
</html>


