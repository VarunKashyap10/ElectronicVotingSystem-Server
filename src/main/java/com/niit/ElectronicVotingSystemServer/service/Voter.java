package com.niit.ElectronicVotingSystemServer.service;

import java.util.ArrayList;

import com.niit.ElectronicVotingSystemServer.bean.CandidateBean;
import com.niit.ElectronicVotingSystemServer.bean.ElectionBean;
import com.niit.ElectronicVotingSystemServer.bean.ResultBean;



public interface Voter {
	
	String castVote(String userId, String electionId, String candidateId);//return 'success','fail','error'
	ArrayList<CandidateBean> viewCandidatesByElectionName(String electionName,String constituency);
	ArrayList<ResultBean> viewListOfElectionsResults();
	String requestVoterId(String userId);
	String viewGeneratedVoterId(String userId, String constituency);
	ArrayList<ElectionBean> viewListOfElections();

}
