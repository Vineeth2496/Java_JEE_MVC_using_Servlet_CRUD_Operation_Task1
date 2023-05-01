package com.servler_curd1;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


public class Dao 
{
	public static Connection mycon()
	{
		Connection con=null;
		try
		{
		FileInputStream fi=new FileInputStream("C:\\Users\\vinee\\OneDrive\\Desktop\\Java\\Practice\\Collections Frame Works\\com.servler_curd1\\src\\JDBC.properties");
		Properties p=new Properties();
		p.load(fi);
		Class.forName(p.getProperty("jdbc.driver")).newInstance();
		con=DriverManager.getConnection(p.getProperty("jdbc.url"), p.getProperty("jdbc.username"), p.getProperty("jdbc.password"));
		System.out.println(con);
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}

	public int register_logic(Data d)
	{
		Connection con= Dao.mycon();
		int res=0;
		try {
			PreparedStatement pst=con.prepareStatement("insert into serstd values(?,?,?,?,?,?,?,?)");
			pst.setString(1, d.getFirstname());
			pst.setString(2, d.getLastname());
			pst.setString(3, d.getEmail());
			pst.setString(4, d.getUserid());
			pst.setString(5, d.getPassword());
			pst.setString(6, d.getStcode());
			pst.setString(7, d.getPhoneno());
			pst.setString(8, d.getGender());
			
			int i=pst.executeUpdate();
			res=i;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	return res;	
	}
	
	public Vector login_logics()
	{
		Vector v=new Vector();
		try
		{
			FileInputStream fi=new FileInputStream("C:\\Users\\vinee\\OneDrive\\Desktop\\Java\\Practice\\Collections Frame Works\\com.servler_curd1\\src\\JDBC.properties");
			Properties p=new Properties();
			p.load(fi);
			Class.forName(p.getProperty("jdbc.driver"));
			RowSetFactory rs=RowSetProvider.newFactory();
			JdbcRowSet jr=rs.createJdbcRowSet();
			jr.setUrl(p.getProperty("jdbc.url"));
			jr.setUsername(p.getProperty("jdbc.username"));
			jr.setPassword(p.getProperty("jdbc.password"));
			jr.setCommand("select Userid, Password from serstd");
			jr.execute();
			for(;jr.next();)
			{
				v.add(jr.getString("Userid"));
				v.add(jr.getString("Password"));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return v;
	}
	
	public static List<Data> profile_logics(Data d)
	{
		List<Data> list=new ArrayList<Data>();
		try
		{
			FileInputStream fi=new FileInputStream("C:\\Users\\vinee\\OneDrive\\Desktop\\Java\\Practice\\Collections Frame Works\\com.servler_curd1\\src\\JDBC.properties");
			Properties p=new Properties();
			p.load(fi);
			Class.forName(p.getProperty("jdbc.driver"));
			RowSetFactory rf=RowSetProvider.newFactory();
			JdbcRowSet jr=rf.createJdbcRowSet();
			jr.setUrl(p.getProperty("jdbc.url"));
			jr.setUsername(p.getProperty("jdbc.username"));
			jr.setPassword(p.getProperty("jdbc.password"));
			jr.setCommand("select * from serstd where Userid=?");
			jr.setString(1, d.getUserid());
			jr.execute();
			
			for(;jr.next();)
			{
				d.setFirstname(jr.getString("firstname"));
				d.setLastname(jr.getString("lastname"));
				d.setEmail(jr.getString("email"));
				d.setUserid(jr.getString("userid"));
				d.setPassword(jr.getString("password"));
				d.setStcode(jr.getString("stdcode"));
				d.setPhoneno(jr.getString("phoneno"));
				d.setGender(jr.getString("gender"));
				list.add(d);
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


}
