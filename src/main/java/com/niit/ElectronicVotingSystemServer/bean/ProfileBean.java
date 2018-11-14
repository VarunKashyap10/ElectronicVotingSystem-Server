package com.niit.ElectronicVotingSystemServer.bean;

import java.sql.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.ElectronicVotingSystemServer.dao.credentialsDAO;
import com.niit.ElectronicVotingSystemServer.daoImpl.credentialsDaoImpl;

@Component
@Entity
@Table(name="evs_tbl_user_profile")
public class ProfileBean {
	@Transient
	@Autowired
	credentialsDAO c;
		
	@Autowired
	@Transient
	CredentialsBean cred;
	
	@Id
	@Column(name="userid")
	private String userID;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	@Column(name="gender")
	private String gender;
	@Column(name="dateofbirth")
	private Date dateOfBirth;
	@Column(name="city")
	private String city;
	@Column(name="street")
	private String street;
	@Column(name="location")
	private String location;
	@Column(name="state")
	private String state;
	@Column(name="pincode")
	private String pincode;
	@Column(name="mobileno")
	private String mobileNo;
	@Column(name="emailid")
	private String emailID;
	@Transient
	private String password;

	
	public ProfileBean(){
		userID="";
		firstName="";
		lastName="";
		gender=""  ;
		dateOfBirth=null;
		city="";
		street="";
		location="";
		pincode="";
		mobileNo="";
		state="";
		emailID="";
		password="";
	}

	public ProfileBean(String fname, String lname,String gend,Date dob,String city,String location,String street,String state,String pin,String mobile,String email,String pass ){
		this.userID=generateUID(fname);
		this.firstName=fname;
		this.lastName=lname;
		this.gender=gend;
		this.dateOfBirth=dob;
		this.city=city;
		this.street=street;
		this.location=location;
		this.state=state;
		this.pincode=pin;
		this.mobileNo=mobile;
		this.emailID=email;
		this.password=pass;
		System.out.println("Creating new Credentials");
		//CredentialsBean cred=new CredentialsBean(this.userID,this.password,"U",0);
		cred.setUserID(this.userID);
		cred.setPassword(this.password);
		cred.setLoginStatus(0);
		cred.setUserType("U");
		System.out.println(cred.toString());
		System.out.println(c);
		c.save(cred);
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String generateUID(String fname){
		String uid=fname.substring(0,2);
		Random rand=new Random();
		int randomSuffix=rand.nextInt(9000);
		randomSuffix+=1000;
		uid+=randomSuffix;
		return uid;
	}
	@Override
	public String toString() {
		return "Profile > \n"+
				"User ID - "+this.userID+"\n"+
				"Name - "+this.firstName + " "+ this.lastName+"\n"+
				"Gender - "+this.gender+"\n"+
				"Date of Birth - "+this.dateOfBirth+"\n"+
				"Address - "+this.street+", "+this.city+", "+this.location+", "+this.pincode+"\n"+
				"Mobile No - "+this.mobileNo;
	}
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
