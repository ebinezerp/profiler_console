package com.niit.profiler.model;

public class Language {
	
	private long profile_Id;
	private String language;
	private boolean read;
	private boolean write;
	private boolean speak;
	
	
	public long getProfile_Id() {
		return profile_Id;
	}
	public void setProfile_Id(long profile_Id) {
		this.profile_Id = profile_Id;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public boolean isRead() {
		return read;
	}
	public void setRead(boolean read) {
		this.read = read;
	}
	public boolean isWrite() {
		return write;
	}
	public void setWrite(boolean write) {
		this.write = write;
	}
	public boolean isSpeak() {
		return speak;
	}
	public void setSpeak(boolean speak) {
		this.speak = speak;
	}
	@Override
	public String toString() {
		return "Language [profile_Id=" + profile_Id + ", language=" + language + ", read=" + read + ", write=" + write
				+ ", speak=" + speak + "]";
	}
	
	

}
