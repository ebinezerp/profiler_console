package com.niit.profiler.model;

public class Profile {

	private long profile_Id;
	private String username;
	private String email;
	private String mobile;
	private String password;
	private String role;
	private boolean status;
	
	public Profile()
	{
		
	}
	
	

	public Profile(long profile_Id, String username, String email, String mobile, String password, String role,
			boolean status) {
		super();
		this.profile_Id = profile_Id;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
		this.status = status;
	}



	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public long getProfile_Id() {
		return profile_Id;
	}

	public void setProfile_Id(long profile_Id) {
		this.profile_Id = profile_Id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Profile [profile_Id=" + profile_Id + ", username=" + username + ", email=" + email + ", mobile="
				+ mobile + ", password=" + password + ", role=" + role + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (profile_Id != other.profile_Id)
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (status != other.status)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
	
}
