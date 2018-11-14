package com.niit.ElectronicVotingSystemServer.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.ElectronicVotingSystemServer.bean.ApplicationBean;
import com.niit.ElectronicVotingSystemServer.bean.CandidateBean;
import com.niit.ElectronicVotingSystemServer.bean.ElectionBean;
import com.niit.ElectronicVotingSystemServer.bean.ResultBean;
import com.niit.ElectronicVotingSystemServer.dao.applicationDAO;
import com.niit.ElectronicVotingSystemServer.dao.candidateDAO;
import com.niit.ElectronicVotingSystemServer.dao.electionDAO;
import com.niit.ElectronicVotingSystemServer.dao.partyDAO;
import com.niit.ElectronicVotingSystemServer.dao.voterDAO;
import com.niit.ElectronicVotingSystemServer.daoImpl.applicationDaoImpl;
import com.niit.ElectronicVotingSystemServer.daoImpl.candidateDaoImpl;
import com.niit.ElectronicVotingSystemServer.daoImpl.electionDaoImpl;
import com.niit.ElectronicVotingSystemServer.daoImpl.voterDaoImpl;
import com.niit.ElectronicVotingSystemServer.service.Voter;

@Service
public class VoterImpl implements Voter{
	@Autowired
	electionDAO elec;
	@Autowired
	partyDAO par;
	@Autowired 
	candidateDAO  candid;
	@Autowired
	applicationDAO appd;
	public String castVote(String userId, String electionId, String candidateId) {
		//applicationDAO appd=new applicationDaoImpl();
		ApplicationBean app=appd.findById(userId).get();
		voterDAO v=new voterDaoImpl();
		if(v.checkVoterValidity(app.getVoterID())) {
			return v.addVoter(candidateId, electionId,app.getVoterID());
		}
		else {
			return "ALREADY CAST";
		}
	}
	public ArrayList<CandidateBean> viewCandidatesByElectionName(String electionName,String constituency) {
		//candidateDAO candid=new candidateDaoImpl();
		//electionDAO elec=new electionDaoImpl();
		ArrayList<ElectionBean> arr=(ArrayList<ElectionBean>) elec.findAll();
		ArrayList<CandidateBean> candidates=(ArrayList<CandidateBean>) candid.findAll();
		ArrayList<CandidateBean> result=new ArrayList<CandidateBean>();
		for(ElectionBean e:arr) {
			if(e.getName().equals(electionName)) {
				for(CandidateBean c:candidates) {
					if(c.getElectionID().equals(e.getElectionID()) && c.getConstituency().equals(constituency)) {
						result.add(c);
					}
				}
			}
		}

		return result;
	}
	public ArrayList<ResultBean> viewListOfElectionsResults(){
		return null;
	}
	public String requestVoterId(String userId) {
		//applicationDAO appd=new applicationDaoImpl();
		ApplicationBean app=appd.findById(userId).get();
		if(app.getPassedStatus()==0)
			app.setPassedStatus(1);
		else 
			System.out.println("Application Error");
		return null;
	}
	public String viewGeneratedVoterId(String userId, String constituency) {
		//applicationDAO appd=new applicationDaoImpl();
		ApplicationBean app=appd.findById(userId).get();
		if(app.getApprovedStatus()==3) {
			return app.getVoterID();
		}
		return null;
	}
	public ArrayList<ElectionBean> viewListOfElections(){
		//electionDAO elec=new electionDaoImpl();
		ArrayList<ElectionBean> arr=(ArrayList<ElectionBean>) elec.findAll();
		return arr;
	}
}
