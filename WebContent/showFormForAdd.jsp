<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding New Customer Page</title>
</head>
<body>
	<div id="div">
		<div id = "header">
				<h1>CRM - Customer Repationship Manager</h1>
				<h2>Enter Customer Details</h2>
		</div>
		<br>
		<div id="detailsform">
			<form action="AddCustomerController">
				Enter the First Name : <input type="text" name="fname"><br><br>
				Enter the Last Name : <input type="text" name="lname"><br><br>
				Enter the Email : <input type="text" name="email"><br><br>
				
				<input type="submit" value="SAVE">		
			</form>
		</div>
	</div>
</body>
</html>