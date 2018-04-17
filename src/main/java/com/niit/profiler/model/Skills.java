package com.niit.profiler.model;

public class Skills {
	
	private long profile_Id;
	private String skillName;
	private int monthsOfPractice;
	private int monthsOfTraining;
	
	
	public int getMonthsOfTraining() {
		return monthsOfTraining;
	}
	public void setMonthsOfTraining(int monthsOfTraining) {
		this.monthsOfTraining = monthsOfTraining;
	}
	public long getProfile_Id() {
		return profile_Id;
	}
	public void setProfile_Id(long profile_Id) {
		this.profile_Id = profile_Id;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public int getMonthsOfPractice() {
		return monthsOfPractice;
	}
	public void setMonthsOfPractice(int monthsOfPractice) {
		this.monthsOfPractice = monthsOfPractice;
	}
	@Override
	public String toString() {
		return "Skills [profile_Id=" + profile_Id + ", skillName=" + skillName + ", monthsOfPractice="
				+ monthsOfPractice + ", monthsOfTraining=" + monthsOfTraining + "]";
	}
	
	

}
