<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.wu.crmdemo.entity.Customer" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>
</head>
<body>
	<div>
		<div>
			<h1>CRM - Customer Relationship Management</h1>
			<h2>Here is the list of customers...</h2>
		</div>
		<br>
		<div id="buttondiv">
			<form action="showFormForAdd.jsp">
				<input type="submit" value="Add Customer">
			</form>
		</div>
		<br>
		<div id="tablediv">
			<table style="border-collapse: collapse; background:#ffbb00;">
			  <tr>
			    <th style="border: 1px solid black; padding: 10px;">First Name</th>
			    <th style="border: 1px solid black; padding: 10px;">Last Name</th>
			    <th style="border: 1px solid black; padding: 10px;">Email</th>
			    <th style="border: 1px solid black; padding: 10px;">Update</th>
			    <th style="border: 1px solid black; padding: 10px;">Delete</th>
			  </tr>
			  <% ArrayList<Customer> customers=(ArrayList<Customer>)request.getAttribute("custdata");
			  for(Customer c: customers)
			  {
			  %>
			   <tr>
			    <td style="border: 1px solid black; padding: 10px;"><%=c.getFirstName() %></td>
			    <td style="border: 1px solid black; padding: 10px;"><%=c.getLastName() %></td>
			    <td style="border: 1px solid black; padding: 10px;"><%=c.getEmail() %></td>
			    <td style="border: 1px solid black; padding: 10px;">
			    	<a href="showFormForUpdate.jsp?firstName=<%=c.getFirstName() %>
			    	&lastName=<%=c.getLastName() %>&email=<%=c.getEmail() %>">
			    		Update
		    		</a>
	    		</td>
	    		<td style="border: 1px solid black; padding: 10px;">
			    	<a href="DeleteCustomerServlet?email=<%=c.getEmail() %>">
			    		Delete
		    		</a>
	    		</td>
			  </tr>
			  <% } %>
			</table>
		</div>
	</div>
</body>
</html>