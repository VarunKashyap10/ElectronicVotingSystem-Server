package com.niit.ElectronicVotingSystemServer.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.ElectronicVotingSystemServer.bean.ApplicationBean;
import com.niit.ElectronicVotingSystemServer.bean.CandidateBean;
import com.niit.ElectronicVotingSystemServer.bean.ElectionBean;
import com.niit.ElectronicVotingSystemServer.bean.PartyBean;
import com.niit.ElectronicVotingSystemServer.dao.applicationDAO;
import com.niit.ElectronicVotingSystemServer.dao.candidateDAO;
import com.niit.ElectronicVotingSystemServer.dao.electionDAO;
import com.niit.ElectronicVotingSystemServer.dao.partyDAO;
import com.niit.ElectronicVotingSystemServer.daoImpl.applicationDaoImpl;
import com.niit.ElectronicVotingSystemServer.daoImpl.candidateDaoImpl;
import com.niit.ElectronicVotingSystemServer.daoImpl.electionDaoImpl;
import com.niit.ElectronicVotingSystemServer.daoImpl.partyDaoImpl;
import com.niit.ElectronicVotingSystemServer.service.Administrator;


@Service
public class AdministratorImpl implements Administrator{
	@Autowired
	electionDAO elec;
	@Autowired
	partyDAO par;
	@Autowired 
	candidateDAO  cre;
	@Autowired
	applicationDAO appd;
	public AdministratorImpl(electionDAO elec,partyDAO par,candidateDAO cre,applicationDAO appd){
		this.elec=elec;
		this.par=par;
		this.cre=cre;
		this.appd=appd;
	}
	
	public String addElection(ElectionBean electionBean) {
		try {
		//electionDAO elec=new electionDaoImpl();
			elec.save(electionBean);
			return "SUCCESS";
		
		}catch(Exception err) {
			System.out.println(err);
		}
		return "ERROR";
		
	}
	
	public ArrayList<ElectionBean> viewAllUpcomingElections(){
		System.out.println("View Upcoming Elections");
		//electionDAO ele=new electionDaoImpl();
		ArrayList<ElectionBean> arr=(ArrayList<ElectionBean>) elec.findAll();
		int i=0;
		for(ElectionBean e:arr) {
			System.out.println(e.getElectionDate());
			Date curr=new Date();
			int test=e.getElectionDate().compareTo(curr);
			System.out.println(test);
			if(test>0) {
				arr.remove(i);
			}
			i++;
		}
		return arr;
		
	}
	public ArrayList<ElectionBean> viewElections(){
		System.out.println("View All Elections ---> ");
		//electionDAO ele=new electionDaoImpl();
		ArrayList<ElectionBean> arr=(ArrayList<ElectionBean>) elec.findAll();

		return arr;
		
	}
	  
	public String addParty(PartyBean partyBean) {
		System.out.println("Adding Party");
		//partyDAO par=new partyDaoImpl();
		par.save(partyBean);
		return "SUCCESS";
	}
	
	
	public ArrayList<PartyBean> viewAllParty(){
		System.out.println("Showing all Partys");
		//partyDAO par=new partyDaoImpl();
		return (ArrayList<PartyBean>) par.findAll();
		
	}
	
	public String addCandidate(CandidateBean candidateBean) {
		try {
		//candidateDAO cre=new  candidateDaoImpl();
		//String str=cre.createCandidate(candidateBean);
		String str="SUCCESS";
		cre.save(candidateBean);
		if(str.equals("SUCCESS")) {
			return "SUCCESS";
		}
		else return "FAIL";
		}catch(Exception err) {
			System.out.println(err);
		}
		return "ERROR";	
	}
	
	public ArrayList<CandidateBean> viewCandidateDetailsByElectionName(String electionName){
		try {
			//candidateDAO cre=new candidateDaoImpl();
			//electionDAO elec=new electionDaoImpl();
			ArrayList<CandidateBean> arr=(ArrayList<CandidateBean>) cre.findAll();
			int i=0;
			for(CandidateBean candid:arr) {
				ElectionBean currentElection=elec.findById(candid.getElectionID()).get();
				if(!currentElection.getName().equals(electionName)) {
					arr.remove(i);
				}
				i++;
				
			}
			return arr;
		}catch(Exception err) {
			System.out.println(err);
		}
		
		return null;
		
	}
	public ArrayList<ApplicationBean> viewAllAdminPendingApplications(){
		//applicationDAO appd=new applicationDaoImpl();
		ArrayList<ApplicationBean> appList=(ArrayList<ApplicationBean>) appd.findAll();
		int i=0;
		for(ApplicationBean a:appList) {
			if( a.getPassedStatus()!=1) {
				appList.remove(i);
			}
		}
		
		return appList;
		
	}
	public boolean forwardVoterIDRequest(String userId) {
		//applicationDAO appd=new applicationDaoImpl();
		ApplicationBean app=appd.findById(userId).get();
		if(app.getPassedStatus()==1) {
			app.setPassedStatus(2);
			return true;
		}
		return false;
		
	}
	public ArrayList<CandidateBean> viewCandidateDetailsByParty(String partyId){
		//candidateDAO candid=new candidateDaoImpl();
		ArrayList<CandidateBean> arr=(ArrayList<CandidateBean>) cre.findAll();
		int i=0;
		for(CandidateBean c:arr) {
			if(!c.getPartyID().equals(partyId)) {
				arr.remove(i);
			}
			i++;
		}
		return arr;
		
	}
	public Map approveElectionResults(String electionId) {
		return null;
		
	}
	
	public String deleteElection(String electionid) {
		try {
			elec.deleteById(electionid);
			return "SUCCESS";			
		}catch(Exception err) {
			err.printStackTrace();
			return "FAIL";
		}
	}

}
