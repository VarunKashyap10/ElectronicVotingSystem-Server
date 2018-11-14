package com.niit.ElectronicVotingSystemServer.service;

import java.util.ArrayList;

import com.niit.ElectronicVotingSystemServer.bean.ApplicationBean;


public interface ElectoralOfficer {
	
	String generateVoterId(String userId, String status);
	ArrayList<ApplicationBean> viewAllVoterIdApplications();
	
}
