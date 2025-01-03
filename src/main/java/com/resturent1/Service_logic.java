package com.resturent1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Vector;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Service_logic {
	public int logic_booking(Data d)
	{
		int i=0;
		
		try
		{
			FileInputStream fi=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\com.resturent\\src\\main\\java\\com\\resturent1\\jdbc.properties");
			Properties p=new Properties();
			p.load(fi);
			
			Class.forName(p.getProperty("jdbc.driver")).newInstance();
			Connection con=DriverManager.getConnection(p.getProperty("jdbc.url"),p.getProperty("jdbc.username"),p.getProperty("jdbc.password"));
			
			PreparedStatement ps=con.prepareStatement("insert into bookings values(?,?,?,?,?,?,?)");
			ps.setString(1, d.getName());
			ps.setString(2, d.getEmail());
			ps.setString(3, d.getPhone());
			ps.setString(4, d.getDob());
			ps.setString(5, d.getTime());
			ps.setString(6, d.getPeople());
			ps.setString(7, d.getMessage());
			
			i=ps.executeUpdate();
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
	}
	
	public int logic_contact(contactdata d1)
	{
		int i=0;
		try
		
		{
			FileInputStream fi=new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\com.resturent\\src\\main\\java\\com\\resturent1\\jdbc.properties");
			Properties p=new Properties();
			p.load(fi);
		Class.forName(p.getProperty("jdbc.driver")).newInstance();
		Connection con=DriverManager.getConnection(p.getProperty("jdbc.url"),p.getProperty("jdbc.username"),p.getProperty("jdbc.password"));
		PreparedStatement pst=con.prepareStatement("insert into contacttable values(?,?,?,?)");
		pst.setString(1, d1.getName());
		pst.setString(2, d1.getEmail());
		pst.setString(3, d1.getSubject());
		pst.setString(4,d1.getMessage());
	i=pst.executeUpdate();
			
		}
		
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return i;
		
		
	}
	
	
	public Vector<Data> logic_bookingdetails(Data d)
	{
		Vector v=new Vector();
		
		try 
		{
			FileInputStream fi=new FileInputStream("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\com.resturent\\\\src\\\\main\\\\java\\\\com\\\\resturent1\\\\jdbc.properties");
			Properties p=new Properties();
			p.load(fi);
			
			Class.forName(p.getProperty("jdbc.driver")).newInstance();
			RowSetFactory rs=RowSetProvider.newFactory();
			JdbcRowSet jr=rs.createJdbcRowSet();
			jr.setUrl(p.getProperty("jdbc.url"));
			jr.setUsername(p.getProperty("jdbc.username"));
			jr.setPassword(p.getProperty("jdbc.password"));
			jr.setCommand("select * from bookings");
			jr.execute();
			
			for(;jr.next();)
			{
				Data d1=new Data();
				d1.setName(jr.getString("name"));
				d1.setEmail(jr.getString("email"));
				d1.setPhone(jr.getString("phone"));
				d1.setDob(jr.getString("dob"));
				d1.setTime(jr.getString("time"));
				d1.setPeople(jr.getString("people"));
				d1.setMessage(jr.getString("message"));
				
				v.add(d1);
				
			}
			
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return v;
	}
	
	public Vector<contactdata> logic_queriedetails(contactdata d)
	{
		Vector v=new Vector();
		
		try 
		{
			FileInputStream fi=new FileInputStream("C:\\\\Users\\\\hp\\\\eclipse-workspace\\\\com.resturent\\\\src\\\\main\\\\java\\\\com\\\\resturent1\\\\jdbc.properties");
			Properties p=new Properties();
			p.load(fi);
			
			Class.forName(p.getProperty("jdbc.driver")).newInstance();
			RowSetFactory rs=RowSetProvider.newFactory();
			JdbcRowSet jr=rs.createJdbcRowSet();
			jr.setUrl(p.getProperty("jdbc.url"));
			jr.setUsername(p.getProperty("jdbc.username"));
			jr.setPassword(p.getProperty("jdbc.password"));
			jr.setCommand("select * from contacttable");
			jr.execute();
			
			for(;jr.next();)
			{
				contactdata d1=new contactdata();
				
				d1.setName(jr.getString("name"));
				d1.setEmail(jr.getString("email"));
				d1.setSubject(jr.getString("subject"));
				d1.setMessage(jr.getString("message"));
				
				v.add(d1);
				
			}
		} 
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		return v;
	}

}
