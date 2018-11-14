package com.niit.ElectronicVotingSystemServer.service;

import java.util.ArrayList;
import java.util.Map;

import com.niit.ElectronicVotingSystemServer.bean.ApplicationBean;
import com.niit.ElectronicVotingSystemServer.bean.CandidateBean;
import com.niit.ElectronicVotingSystemServer.bean.ElectionBean;
import com.niit.ElectronicVotingSystemServer.bean.PartyBean;



public interface Administrator {
	
	String addElection(ElectionBean electionBean);
	ArrayList<ElectionBean> viewAllUpcomingElections();
	ArrayList<ElectionBean> viewElections();
	String addParty(PartyBean partyBean);
	ArrayList<PartyBean> viewAllParty();
	String addCandidate(CandidateBean candidateBean);
	ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String electionName);
	ArrayList<ApplicationBean> viewAllAdminPendingApplications();
	boolean forwardVoterIDRequest(String userId);
	ArrayList<CandidateBean> viewCandidateDetailsByParty(String partyId);
	Map approveElectionResults(String electionId);	
	
}
