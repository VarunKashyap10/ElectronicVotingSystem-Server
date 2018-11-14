package com.niit.ElectronicVotingSystemServer.bean;

import java.util.Optional;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.ElectronicVotingSystemServer.dao.credentialsDAO;
import com.niit.ElectronicVotingSystemServer.dao.profileDAO;
import com.niit.ElectronicVotingSystemServer.daoImpl.profileDaoImpl;


@Component
@Entity
@Table(name="evs_tbl_application")
public class ApplicationBean {
	@Autowired
	@Transient
	profileDAO cred;
	
	@Id
	@Column(name="userid")
	private String userID;
	@Column(name="constituency")
	private String constituency;
	@Column(name="passedstatus")
	private int passedStatus;
	@Column(name="approvedstatus")
	private int approvedStatus;
	@Column(name="voterid")
	private String voterID;
	public ApplicationBean(){
		userID="";
		constituency="";
		passedStatus=0;
		approvedStatus=0;
		voterID="";
	}
	public ApplicationBean(String uid, String cons,int pass,int app) {
		this.userID=uid;
		this.constituency=cons;
		this.passedStatus=pass;
		this.approvedStatus=app;
		this.voterID=null;
	}
	public ApplicationBean(String uid, String cons,int pass,int app,String appid) {
		this.userID=uid;
		this.constituency=cons;
		this.passedStatus=pass;
		this.approvedStatus=app;
		this.voterID=appid;
	}
	String generateVoterID(String uid,String cons) {
		//profileDaoImpl cred=new profileDaoImpl();
		Optional<ProfileBean> user=cred.findById(uid);
		String vid=user.get().getFirstName().substring(0,2);
		vid+=cons.substring(0, 2);
		Random rand=new Random();
		int randomSuffix=rand.nextInt(9000);
		randomSuffix+=1000;
		vid+=randomSuffix;
		return vid;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public int getPassedStatus() {
		return passedStatus;
	}
	public void setPassedStatus(int passedStatus) {
		this.passedStatus = passedStatus;
	}
	public int getApprovedStatus() {
		return approvedStatus;
	}
	public void setApprovedStatus(int approvedStatus) {
		this.approvedStatus = approvedStatus;
	}
	public String getVoterID() {
		return voterID;
	}
	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}
	

}
