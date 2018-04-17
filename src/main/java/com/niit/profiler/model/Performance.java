package com.niit.profiler.model;

public class Performance {

	private long profile_id;
	private int no_Of_Batches_Taught;
	private int hours_Of_teaching;
	private int no_Of_Student_Placed;

	public long getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(long profile_id) {
		this.profile_id = profile_id;
	}

	public int getNo_Of_Batches_Taught() {
		return no_Of_Batches_Taught;
	}

	public void setNo_Of_Batches_Taught(int no_Of_Batches_Taught) {
		this.no_Of_Batches_Taught = no_Of_Batches_Taught;
	}

	public int getHours_Of_teaching() {
		return hours_Of_teaching;
	}

	public void setHours_Of_teaching(int hours_Of_teaching) {
		this.hours_Of_teaching = hours_Of_teaching;
	}

	public int getNo_Of_Student_Placed() {
		return no_Of_Student_Placed;
	}

	public void setNo_Of_Student_Placed(int no_Of_Student_Placed) {
		this.no_Of_Student_Placed = no_Of_Student_Placed;
	}

	@Override
	public String toString() {
		return "Performance [profile_id=" + profile_id + ", no_Of_Batches_Taught=" + no_Of_Batches_Taught
				+ ", hours_Of_teaching=" + hours_Of_teaching + ", no_Of_Student_Placed=" + no_Of_Student_Placed + "]";
	}

	
}
