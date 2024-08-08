package com.jsp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Details")
public class Userinformation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	@Column(name="Last_Name", length=45)
	private String lastname;
	@Column(name="First_Name", length=45)
	private String firstname;
	@Column(name="Email_Id", length=45, unique = true, nullable = false)
	private String emailid;
	@Column(length=4,unique = true, nullable = false)
	private String password;
	@Column(name="Mobile_Number", length=10, unique = true, nullable = false)
	private long mobilenumber;
	@Column(length=45, nullable=false)
	private String gender;
	
	public Userinformation()
	{
		
	}

	public Userinformation(int userid, String lastname, String firstname, String emailid, String password,
			long mobilenumber, String gender) {
		super();
		this.userid = userid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.emailid = emailid;
		this.password = password;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(long mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Userinformation [userid=" + userid + ", lastname=" + lastname + ", firstname=" + firstname
				+ ", emailid=" + emailid + ", password=" + password + ", mobilenumber=" + mobilenumber + ", gender="
				+ gender + "]";
	}
	
}
