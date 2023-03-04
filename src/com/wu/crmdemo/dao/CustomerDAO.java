package com.wu.crmdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.wu.crmdemo.entity.Customer;

public class CustomerDAO {
	String databaseDriver="oracle.jdbc.driver.OracleDriver";
	String connectionURL="jdbc:oracle:thin:@localhost:1521:XE";
	String userName="employee";
	String passWord="ubuntu";
	String sqlQuery="select * from Customer";
	
	public ArrayList<Customer> getCustomer(){
		
		ArrayList<Customer> customers=new ArrayList<>();
		
		try {
			
			Class.forName(databaseDriver);
			Connection con=DriverManager.getConnection(connectionURL, userName, passWord);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sqlQuery);
			
			while(rs.next())
			{
				Customer c1=new Customer();
				c1.setFirstName(rs.getString(1));
				c1.setLastName(rs.getString(2));
				c1.setEmail(rs.getString(3));
				customers.add(c1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customers;
	}

	public void addCustomer(String firstName, String lastName, String email) {
		try {
		
			Class.forName(databaseDriver);
			Connection con=DriverManager.getConnection(connectionURL, userName, passWord);
			
			PreparedStatement stmt=con.prepareStatement("insert into customer values(?,?,?)");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, email);
			
			stmt.executeUpdate();
			con.commit();
			con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateCustomer(String firstName, String lastName, String email, String queryWhereClause) {
		// TODO Auto-generated method stub
		try {
			
			Class.forName(databaseDriver);
			Connection con=DriverManager.getConnection(connectionURL, userName, passWord);
			
			PreparedStatement stmt=con.prepareStatement("update customer set first_name=?, last_name=?, email=? where last_name=?");
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, email);
			stmt.setString(4, queryWhereClause);
			
			int i=stmt.executeUpdate();
			System.out.println(i+" Record Updated!");
			
			con.commit();
			con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteCustomer(String email) {
		// TODO Auto-generated method stub
		try {
			Class.forName(databaseDriver);
			Connection con=DriverManager.getConnection(connectionURL, userName, passWord);
			
			PreparedStatement stmt=con.prepareStatement("delete from customer where email=?");
			stmt.setString(1, email);
			
			int i=stmt.executeUpdate();
			System.out.println(i+" Record Deleted!");
			
			con.commit();
			con.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
