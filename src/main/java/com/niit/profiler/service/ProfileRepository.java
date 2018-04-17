package com.niit.profiler.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.niit.profiler.model.Profile;
import com.niit.profiler.utility.DBConnection;

public class ProfileRepository {
	
	private Connection connection;
	private static Properties properties;
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
	
	public ProfileRepository()
	{
		connection=new DBConnection().getConnection();
	}
	
	
	
	public boolean insert(Profile profile)
	{
		if(!validate(profile))
			return false;
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement=connection.prepareStatement("insert into profile values(?,?,?,?,?,?,?)");
			preparedStatement.setLong(1, profile.getProfile_Id());
			preparedStatement.setString(2, profile.getUsername());
			preparedStatement.setString(3, profile.getEmail());
			preparedStatement.setString(4, profile.getMobile());
			preparedStatement.setString(5, profile.getPassword());
			preparedStatement.setString(7, profile.getRole());
			preparedStatement.setBoolean(6,profile.getStatus());
			if(preparedStatement.executeUpdate()>0)
			{
				return true;
			}else
			{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
	public boolean delete(long profile_id)
	{
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement=connection.prepareStatement("delete from profile where profile_id=?");
			preparedStatement.setLong(1, profile_id);
			if(preparedStatement.executeUpdate()>0)
			{
				return true;
			}else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
				
	}
	
	
	public boolean profileAccept(long profile_id)
	{
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement=connection.prepareStatement("update profile set status=true where profile_id=?");
			preparedStatement.setLong(1, profile_id);
			if(preparedStatement.executeUpdate()>0)
			{
				return true;
			}else
			{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean update(Profile profile)
	{
		if(!validate(profile))
			return false;
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement=connection.prepareStatement("update profile set profile_id=?,username=?,email=?,mobile=?,password=?,status=?,role=? where profile_id=?");
			preparedStatement.setLong(1, profile.getProfile_Id());
			preparedStatement.setString(2, profile.getUsername());
			preparedStatement.setString(3, profile.getEmail());
			preparedStatement.setString(4, profile.getMobile());
			preparedStatement.setString(5, profile.getPassword());
			preparedStatement.setString(7, profile.getRole());
			preparedStatement.setBoolean(6,profile.getStatus());
			preparedStatement.setLong(8, profile.getProfile_Id());
			if(preparedStatement.executeUpdate()>0)
			{
				return true;
			}else
			{
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	
	private boolean validate(Profile profile)
	{
		Pattern profileIdPattern=Pattern.compile(properties.getProperty("profileId"));
		Matcher matcher=profileIdPattern.matcher(new Long(profile.getProfile_Id()).toString());
		if(!matcher.matches())
		{
			return false;
		}
		
		Pattern usernamePattern=Pattern.compile(properties.getProperty("username"));
		matcher=usernamePattern.matcher(profile.getUsername());
		if(!matcher.matches())
		{
			return false;
		}
		
		Pattern emailPattern=Pattern.compile(properties.getProperty("email"));
		matcher=emailPattern.matcher(profile.getEmail());
		if(!matcher.matches())
		{
			return false;
		}
		
		Pattern mobilePattern=Pattern.compile(properties.getProperty("mobile"));
		matcher=mobilePattern.matcher(profile.getMobile());
		if(!matcher.matches())
		{
			return false;
		}
		
		Pattern passwordPattern=Pattern.compile(properties.getProperty("password"));
		matcher=passwordPattern.matcher(profile.getPassword());
		if(!matcher.find())
		{
			return false;
		}
		
		Pattern rolePattern=Pattern.compile(properties.getProperty("role"));
		matcher=rolePattern.matcher(profile.getRole());
		if(!matcher.matches())
		{
			return false;
		}
		
		Pattern statusPattern=Pattern.compile(properties.getProperty("status"));
		matcher=statusPattern.matcher(new Boolean(profile.getStatus()).toString());
		if(!matcher.matches())
		{
			return false;
		}
		
		
		return true;
		
	}

}
