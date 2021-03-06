package com.niit.profiler.model;

import java.util.Date;

public class PersonalData {
	
	
	private long profile_Id;
	private String firstname;
	private String lastname;
	private String gender;
	private Date date_Of_Birth;
	private boolean marital_Status;
	private String city;
	private long supervisor;
	
	public PersonalData()
	{
		
	}
	
	
	public PersonalData(long profile_Id, String firstname, String lastname, String gender, Date date_Of_Birth,boolean marital_Status, String city, long supervisor) {
		super();
		this.profile_Id = profile_Id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.date_Of_Birth = date_Of_Birth;
		this.marital_Status = marital_Status;
		this.city = city;
		this.supervisor = supervisor;
	}






	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(long supervisor) {
		this.supervisor = supervisor;
	}
	public long getProfile_Id() {
		return profile_Id;
	}
	public void setProfile_Id(long profile_Id) {
		this.profile_Id = profile_Id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate_Of_Birth() {
		return date_Of_Birth;
	}
	public void setDate_Of_Birth(Date date_Of_Birth) {
		this.date_Of_Birth = date_Of_Birth;
	}
	public boolean isMarital_Status() {
		return marital_Status;
	}
	public void setMarital_Status(boolean marital_Status) {
		this.marital_Status = marital_Status;
	}
	@Override
	public String toString() {
		return "PersonalData [profile_Id=" + profile_Id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", gender=" + gender + ", date_Of_Birth=" + date_Of_Birth + ", marital_Status=" + marital_Status
				+ ", city=" + city + ", supervisor=" + supervisor + "]";
	}
	
	
	
	 

}
