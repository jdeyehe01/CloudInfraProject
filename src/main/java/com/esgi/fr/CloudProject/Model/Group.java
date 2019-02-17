package com.esgi.fr.CloudProject.Model;

import java.util.List;

public class Group {
	
	private String name;
	private String id;
	private String type;
	private List<User> memebers;
		
	
	public Group() {
	}

	public Group(String name, String id, String type, List<User> memebers) {
		super();
		this.name = name;
		this.id = id;
		this.type = type;
		this.memebers = memebers;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<User> getMemebers() {
		return memebers;
	}
	public void setMemebers(List<User> memebers) {
		this.memebers = memebers;
	}
	
	@Override
	public String toString() {
		return "Group [name=" + name + ", id=" + id + ", type=" + type + ", memebers=" + memebers + "]";
	}
}
