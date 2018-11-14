package com.niit.ElectronicVotingSystemServer.dao;

public interface voterDAO {
	String addVoter(String candidateid,String electionid,String voterid);

	boolean checkVoterValidity(String voterid);
	
}
