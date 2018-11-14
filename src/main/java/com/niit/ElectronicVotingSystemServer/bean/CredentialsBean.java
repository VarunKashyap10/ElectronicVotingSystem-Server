package com.niit.ElectronicVotingSystemServer.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="evs_tbl_user_credentials",uniqueConstraints = {
		@UniqueConstraint(columnNames="userid")
})
public class CredentialsBean {
	private String userID;
	private String password;
	private String userType;
	private int loginStatus;
	public CredentialsBean(){
		userID="";
		password="";
		userType="";
		loginStatus=-1;
		
	}
	public CredentialsBean(String userid,String pass) {
		userID=userid;
		password=pass;
		userType="";
		loginStatus=0;
	}
	public CredentialsBean(String userid,String pass,String utype,int status) {
		userID=userid;
		password=pass;
		userType=utype;
		loginStatus=status;
	}
	@Id
	@Column(name="userid",unique=true,nullable=false)
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	@Column(name="password",nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="usertype",nullable=false)
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Column(name="loginstatus",nullable=false)
	public int getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(int loginStatus) {
		this.loginStatus = loginStatus;
	}
	@Override
	public String toString() {
		return "User Credentials > "+userID+" | Password > "+password+" | UserType > "+userType+" | LoginStatus > "+loginStatus ;
		
	}
}
