package com.niit.ElectronicVotingSystemServer.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="evs_tbl_result")
public class ResultBean {
	@Id
	@Column(name="serialno")
	int resultNo;
	@Column(name="electionid")
	String electionID;
	@Column(name="candidateid")
	String candidateID;
	@Column(name="votecount")
	int voteCount;
	public ResultBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultBean(int resultNo, String electionID, String candidateID, int voteCount) {
		super();
		this.resultNo = resultNo;
		this.electionID = electionID;
		this.candidateID = candidateID;
		this.voteCount = voteCount;
	}
	public int getResultNo() {
		return resultNo;
	}
	public void setResultNo(int resultNo) {
		this.resultNo = resultNo;
	}
	public String getElectionID() {
		return electionID;
	}
	public void setElectionID(String electionID) {
		this.electionID = electionID;
	}
	public String getCandidateID() {
		return candidateID;
	}
	public void setCandidateID(String candidateID) {
		this.candidateID = candidateID;
	}
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	

}
