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
				<h2>Update Customer Details</h2>
		</div>
		<br>
		<div id="detailsform">
			<form action="UpdateCustomerController">
				Enter the First Name : <input type="text" name="fname" value=<%=request.getParameter("firstName")%>><br><br>
				Enter the Last Name : <input type="text" name="lname" value=<%=request.getParameter("lastName")%>><br><br>
				Enter the Email : <input type="text" name="email" value=<%=request.getParameter("email")%>><br><br>
								  <input type="hidden" name="hidden" value=<%=request.getParameter("lastName")%>>
				<input type="submit" value="SAVE">		
			</form>
		</div>
	</div>
</body>
</html>