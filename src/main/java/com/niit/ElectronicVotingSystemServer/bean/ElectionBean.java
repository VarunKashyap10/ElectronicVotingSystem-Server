package com.niit.ElectronicVotingSystemServer.bean;

import java.util.Date;
import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="evs_tbl_election",uniqueConstraints = {
		@UniqueConstraint(columnNames="electionid")
})
public class ElectionBean {
	@Id
	@Column(name="electionid")
	private String electionID;
	@Column(name="name")
	private String name;
	@Column(name="electiondate")
	private Date electionDate;
	@Column(name="district")
	private String district;
	@Column(name="constituency")
	private String constituency;
	@Column(name="countingdate")
	private Date countingDate;

	
	public ElectionBean() {
		this.electionID="";
		this.name="";
		this.electionDate=null;
		this.district="";
		this.constituency="";
		this.countingDate=null;
	}
	public ElectionBean(String name,Date doe,String dist,String cons,Date coe) {
		this.electionID=generateID(name);
		this.name=name;
		this.electionDate=doe;
		this.district=dist;
		this.constituency=cons;
		this.countingDate=coe;

	}
	public ElectionBean(String uid,String name,Date doe,String dist,String cons,Date coe) {
		this.electionID=uid;
		this.name=name;
		this.electionDate=doe;
		this.district=dist;
		this.constituency=cons;
		this.countingDate=coe;
		
	}
	String generateID(String  name){
		String uid=name.substring(0,2);
		Random rand=new Random();
		int randomSuffix=rand.nextInt(9000);
		randomSuffix+=1000;
		uid+=randomSuffix;
		return uid;
	}
	public String getElectionID() {
		return electionID;
	}
	public void setElectionID() {
		this.electionID = generateID(this.name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getElectionDate() {
		return electionDate;
	}
	public void setElectionDate(Date electionDate) {
		this.electionDate = electionDate;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	public Date getCountingDate() {
		return countingDate;
	}
	public void setCountingDate(Date countingDate) {
		this.countingDate = countingDate;
	}
	@Override
	public String toString() {
		return "Election -> Name - "+this.name+" | ElectionID - "+this.electionID+" | ElectionDate - "+this.electionDate+" | District - "+this.district+" | Constituency - "+this.constituency+" | CountingDate - "+this.countingDate;
	}
}
