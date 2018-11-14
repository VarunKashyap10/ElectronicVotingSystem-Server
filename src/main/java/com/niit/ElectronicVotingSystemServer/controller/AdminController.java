package com.niit.ElectronicVotingSystemServer.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.ElectronicVotingSystemServer.bean.ApplicationBean;
import com.niit.ElectronicVotingSystemServer.bean.CandidateBean;
import com.niit.ElectronicVotingSystemServer.bean.ElectionBean;
import com.niit.ElectronicVotingSystemServer.bean.PartyBean;
import com.niit.ElectronicVotingSystemServer.serviceImpl.AdministratorImpl;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdministratorImpl admin;
	
	AdminController(){
		System.out.println("Admin Controller");
	}
	@PostMapping("/addElection")
	public String addElection(@RequestBody ElectionBean election) {
		election.setElectionID();
		return admin.addElection(election);
	}
	
	@GetMapping("/viewAllElections")
	public List viewAllElections() {
		return admin.viewElections();
	}
	
	@GetMapping("/viewAllUpcomingElections")
	public List viewUpcomingElections() {
		return admin.viewAllUpcomingElections();
	}
	
	@PostMapping("/addParty")
	public String addParty(@RequestBody PartyBean party) {
		return admin.addParty(party);
	}
	
	@GetMapping("/viewAllPartys")
	public List viewAllPartys() {
		return admin.viewAllParty();
	}
	
	@GetMapping("/viewCandidatesByElection/{electionName}")
	public ArrayList<CandidateBean> viewCandidByElection(@PathVariable String electionName) {
		System.out.println(electionName);
		return admin.viewCandidateDetailsByElectionName(electionName);
	}
	
	@PostMapping("/addCandidate")
	public String addCandidate(@RequestBody CandidateBean c) {
		System.out.println(c.toString());
		c.setCandidateID();
		return admin.addCandidate(c);
	}
	
	@GetMapping("/getPendingApplications")
	public ArrayList<ApplicationBean> getApplications() {
		return admin.viewAllAdminPendingApplications();
	}
	
	@DeleteMapping("/deleteElection/{electionid}")
	public void deleteElection(@PathVariable String electionid) {
		admin.deleteElection(electionid);
	}
	
}
