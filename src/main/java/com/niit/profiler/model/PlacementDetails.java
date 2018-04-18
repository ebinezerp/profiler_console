package com.niit.profiler.model;

public class PlacementDetails {

	private long profile_id;
	private String companyName;
	private String designation;
	private String joiningLocation;

	public long getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJoiningLocation() {
		return joiningLocation;
	}

	public void setJoiningLocation(String joiningLocation) {
		this.joiningLocation = joiningLocation;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "PlacementDetails [profile_id=" + profile_id + ", companyName=" + companyName + ", designation="
				+ designation + ", joiningLocation=" + joiningLocation + "]";
	}
	
	
	

}
