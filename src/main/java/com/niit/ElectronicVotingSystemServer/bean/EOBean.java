package com.niit.ElectronicVotingSystemServer.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="evs_tbl_eo")
public class EOBean {
	@Id
	@Column(name="electoralofficerid")
	String electoralOfficerID;
	@Column(name="constituency")
	String constituency;
	public EOBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EOBean(String electoralOfficerID, String constituency) {
		super();
		this.electoralOfficerID = electoralOfficerID;
		this.constituency = constituency;
	}
	public String getElectoralOfficerID() {
		return electoralOfficerID;
	}
	public void setElectoralOfficerID(String electoralOfficerID) {
		this.electoralOfficerID = electoralOfficerID;
	}
	public String getConstituency() {
		return constituency;
	}
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}
	
}
