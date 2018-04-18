package com.niit.profiler.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.niit.profiler.model.PersonalData;
import com.niit.profiler.model.Profile;

public class PersonalDataRepository extends Repository{
	
	
	public boolean insert(PersonalData personalData)
	{
		if(!validate(personalData))
			return false;
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement=connection.prepareStatement("insert into personal_profile values(?,?,?,?,?,?,?,?)");
			preparedStatement.setLong(1, personalData.getProfile_Id());
			preparedStatement.setString(2, personalData.getFirstname());
			preparedStatement.setString(3, personalData.getLastname());
			preparedStatement.setBoolean(4, personalData.isMarital_Status());
			preparedStatement.setDate(5, new java.sql.Date(personalData.getDate_Of_Birth().getYear(),
														   personalData.getDate_Of_Birth().getMonth(),
														   personalData.getDate_Of_Birth().getDate()));
			preparedStatement.setString(6, personalData.getGender());
			preparedStatement.setString(7,personalData.getCity());
			preparedStatement.setLong(8, personalData.getSupervisor());
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
	
	
	
	public PersonalData getPersonalData(long profile_id)
	{
		PreparedStatement preparedStatement;
		PersonalData presonalData=null;
		try {
			preparedStatement=connection.prepareStatement("select * from personal_profile where profile_id=?");
			preparedStatement.setLong(1, profile_id);
			ResultSet rs=preparedStatement.executeQuery();
			if(rs.next())
			{
				presonalData=new PersonalData(rs.getLong("profile_id"), 
						rs.getString("firstname"), 
						rs.getString("lastname"), 
						rs.getString("gender"), 
						rs.getDate("date_of_birth"), 
						rs.getBoolean("marital_status"), 
						rs.getString("city"), 
						rs.getLong("supervisor"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return presonalData;
	}
	

	public boolean delete(long profile_id)
	{
		PreparedStatement preparedStatement;
		
		try {
			preparedStatement=connection.prepareStatement("delete from personal_profile where profile_id=?");
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
	
	private boolean validate(PersonalData personalData)
	{
		Pattern firstnamePattern=Pattern.compile(properties.getProperty("firstname"));
		Matcher matcher=firstnamePattern.matcher(personalData.getFirstname());
		if(!matcher.matches())
		{
			return false;
		}
		
		Pattern lastnamePattern=Pattern.compile(properties.getProperty("lastname"));
		matcher=lastnamePattern.matcher(personalData.getLastname());
		if(!matcher.matches())
		{
			return false;
		}
		
		Pattern maritalPattern=Pattern.compile(properties.getProperty("maritalStatus"));
		matcher=maritalPattern.matcher(new Boolean(personalData.isMarital_Status()).toString());
		if(!matcher.matches())
		{
			return false;
		}
		
		Pattern dobPattern=Pattern.compile(properties.getProperty("date_of_birth"));
		// to format the date
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String date=dateFormat.format(personalData.getDate_Of_Birth());
		
		// matching the date but not modifing in object
		matcher=dobPattern.matcher(date);
		
		if(!matcher.matches())
		{
			return false;
		}
		
		Pattern genderPattern=Pattern.compile(properties.getProperty("gender"));
		matcher=genderPattern.matcher(personalData.getGender());
		
		if(!matcher.matches())
		{
			return false;
		}
		
		Pattern cityPattern=Pattern.compile(properties.getProperty("city"));
		matcher=cityPattern.matcher(personalData.getCity());
		if(!matcher.matches())
		{
			return false;
		}
		
		
		Pattern supPattern=Pattern.compile(properties.getProperty("supervisor"));
		matcher=supPattern.matcher(new Long(personalData.getSupervisor()).toString());
		if(!matcher.matches())
		{
			return false;
		}
		
		
		return true;
		
	}


}
