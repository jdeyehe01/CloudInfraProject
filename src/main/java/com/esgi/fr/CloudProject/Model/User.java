package com.esgi.fr.CloudProject.Model;

public class User {
	private String firstname;
	private String lastname;
	private String email;
	private String username;
	private String _id;

		public User() {
		}

	public User(String _id , String firstname, String lastname, String email) {
		this._id = _id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", _id=" + _id + "]";
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	
	
}
