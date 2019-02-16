package com.esgi.fr.CloudProject.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Holiday {
	private Date begin;
	private Date ending;
	private User user;
	
	
	
	public Holiday(Date begin, Date ending, User user) {
		this.begin = begin;
		this.ending = ending;
		this.user = user;
	}
	
	
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnding() {
		return ending;
	}
	public void setEnding(Date ending) {
		this.ending = ending;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Holiday [begin=" + begin + ", ending=" + ending + ", user=" + user + "]";
	}
	
	
	

}
