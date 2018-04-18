package com.niit.profiler.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.niit.profiler.model.Profile;
import com.niit.profiler.utility.DBConnection;

public class ProfileRepository extends Repository {
	
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
	
	
	public Profile getProfile(long profile_id)
	{
		PreparedStatement preparedStatement;
		Profile profile=null;
		try {
			preparedStatement=connection.prepareStatement("select * from profile where profile_id=?");
			preparedStatement.setLong(1, profile_id);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				profile=new Profile(rs.getLong("profile_id"), rs.getString("username"), rs.getString("email"), rs.getString("mobile"), rs.getString("password"), rs.getString("role"), rs.getBoolean("status"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return profile;
	}
	
	
	
	
	public Set<Profile> getUnApprovedProfiles()
	{
		Statement statement=null;
		HashSet<Profile> profiles=new HashSet<Profile>();
		
		try {
			statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from profile where status=false");
			while(rs.next())
			{
				profiles.add(new Profile(rs.getLong("profile_id"), rs.getString("username"), rs.getString("email"), rs.getString("mobile"), rs.getString("password"), rs.getString("role"), rs.getBoolean("status")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profiles;
	}
	
	
	
	
	
	public Set<Profile> getApprovedProfiles()
	{
		Statement statement=null;
		HashSet<Profile> profiles=new HashSet<Profile>();
		
		try {
			statement=connection.createStatement();
			ResultSet rs=statement.executeQuery("select * from profile where status=true");
			while(rs.next())
			{
				profiles.add(new Profile(rs.getLong("profile_id"), rs.getString("username"), rs.getString("email"), rs.getString("mobile"), rs.getString("password"), rs.getString("role"), rs.getBoolean("status")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profiles;
	}
	
	
	
	public Profile loginValidate(String username,String password)
	{
		PreparedStatement preparedStatement;
		Profile profile=null;
		try {
			preparedStatement=connection.prepareStatement("select * from profile where username=? and password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				profile=new Profile(rs.getLong("profile_id"), rs.getString("username"), rs.getString("email"), rs.getString("mobile"), rs.getString("password"), rs.getString("role"), rs.getBoolean("status"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return profile;
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
