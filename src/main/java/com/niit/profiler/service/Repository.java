package com.niit.profiler.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import com.niit.profiler.utility.DBConnection;

public abstract class Repository {
	
	protected Connection connection;
	protected static Properties properties;
	static
	{
		FileInputStream fileInputStream=null;
	     try {
	    	 fileInputStream=new FileInputStream("reg_exp.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	     
	     
	     properties=new Properties();
	     
	     
	     try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Repository()
	{
		connection=new DBConnection().getConnection();
	}
	

}
