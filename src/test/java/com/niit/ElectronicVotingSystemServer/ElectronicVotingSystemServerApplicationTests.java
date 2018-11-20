package com.niit.ElectronicVotingSystemServer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.type.descriptor.java.ArrayMutabilityPlan;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.niit.ElectronicVotingSystemServer.bean.ApplicationBean;
import com.niit.ElectronicVotingSystemServer.bean.CandidateBean;
import com.niit.ElectronicVotingSystemServer.bean.CredentialsBean;
import com.niit.ElectronicVotingSystemServer.bean.ElectionBean;
import com.niit.ElectronicVotingSystemServer.bean.PartyBean;
import com.niit.ElectronicVotingSystemServer.bean.ProfileBean;
import com.niit.ElectronicVotingSystemServer.dao.applicationDAO;
import com.niit.ElectronicVotingSystemServer.dao.candidateDAO;
import com.niit.ElectronicVotingSystemServer.dao.credentialsDAO;
import com.niit.ElectronicVotingSystemServer.dao.electionDAO;
import com.niit.ElectronicVotingSystemServer.dao.partyDAO;
import com.niit.ElectronicVotingSystemServer.dao.profileDAO;
import com.niit.ElectronicVotingSystemServer.serviceImpl.AdministratorImpl;
import com.niit.ElectronicVotingSystemServer.util.Authentication;
import com.niit.ElectronicVotingSystemServer.util.User;

@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
public class ElectronicVotingSystemServerApplicationTests {
	//@Autowired
	//credentialsDAO cred;
	@Mock
	credentialsDAO cred;
	@Mock
	applicationDAO appd;
	@Mock
	electionDAO ele;
	@Mock
	partyDAO par;
	@Mock
	candidateDAO cand;
	@Mock
	profileDAO pd;
	@Mock
	Authentication a;
	//@InjectMocks
	//AdministratorImpl ad
	//@InjectMocks
	//User user;
	
	//@Autowired
	//TestEntityManager entityManager;
	//@Autowired
	//User user;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void addElectionByAdminTest() {
		//mock(credentialsDAO.class)
		//credentialsDAO cred=mock(credentialsDAO.class);
		//electionDAO ele=mock(electionDAO.class);
		//partyDAO par=mock(partyDAO.class);
		//applicationDAO appd=mock(applicationDAO.class);
		//candidateDAO cand=mock(candidateDAO.class);
		AdministratorImpl ad=new AdministratorImpl(ele,par,cand,appd);
		//CredentialsBean cre=new CredentialsBean("VK9999","qwerty1","A",0);
		//when(cred.findById("VK9999")).thenReturn (Optional.of(cre));
		String result=ad.addElection(new ElectionBean("IPL",Date.valueOf(LocalDate.parse("2018-10-12")),"Delhi","Delhi",Date.valueOf(LocalDate.parse("2019-01-01"))));
		assertEquals("SUCCESS",result);
	}
	
	@Test
	public void addPartyTest() {
		AdministratorImpl ad=new AdministratorImpl(ele,par,cand,appd);
		String result=ad.addParty(new PartyBean("BJP","NAMO","Hand"));
		assertEquals("SUCCESS",result);
	}
	
	@Test
	public void viewPartyTest() {
		ArrayList<PartyBean>test=new ArrayList<PartyBean>();
		test.add(new PartyBean("BJP","NAMO","Hand"));
		when(par.findAll()).thenReturn(test);
		AdministratorImpl ad=new AdministratorImpl(ele,par,cand,appd);
		ArrayList<PartyBean>arr=ad.viewAllParty();
		System.out.println(arr.get(0).toString());
		assertEquals(test,arr);
	}
	@Test
	public void addCandidateTest() {
		AdministratorImpl ad=new AdministratorImpl(ele,par,cand,appd);
		String result=ad.addCandidate(new CandidateBean("Varun", "tre","asdd","Delhi","Delhi", Date.valueOf(LocalDate.parse("2018-10-12")),"9999999999","ADs asd","kvarun10@gmail.com"));
		assertEquals("Adding Candidate Failed","SUCCESS",result);
	}
	@Test
	public void viewCandidateByElectionNameTest() {
		ArrayList<CandidateBean> arrC=new ArrayList<CandidateBean>();
		arrC.add(new CandidateBean("Varun", "ele1","par1","Delhi","Delhi", Date.valueOf(LocalDate.parse("2018-10-12")),"9999999999","ADs asd","kvarun10@gmail.com"));
		arrC.add(new CandidateBean("Kashyap", "ele1","par1","Delhi","Delhi", Date.valueOf(LocalDate.parse("2012-10-12")),"8888888888","ADsasd asd","kvarun@gmail.com"));
		
		
		when(cand.findAll()).thenReturn(arrC);
		when(ele.findById("ele1")).thenReturn(Optional.ofNullable(new ElectionBean("ele1","LokSabhqa", Date.valueOf(LocalDate.parse("2018-10-12")),"Delhi","Delhi",Date.valueOf(LocalDate.parse("2012-10-12")))));
		AdministratorImpl ad=new AdministratorImpl(ele,par,cand,appd);
		ArrayList<CandidateBean> arr2=ad.viewCandidateDetailsByElectionName("LokSabha");
		assertEquals("Candidate by ElectionName Failed",arrC,arr2);

	}
	
	@Test
	public void viewApplicaionsTest() {
		ArrayList<ApplicationBean> arr=new ArrayList<ApplicationBean>();
		arr.add(new ApplicationBean("VK122", "Delhi",1,0));
		arr.add(new ApplicationBean("SA123", "Delhi",1,0));
		arr.add(new ApplicationBean("ASD12", "Delhi",1,0));
		arr.add(new ApplicationBean("TG123", "Delhi",1,0));
		//ArrayList<ApplicationBean> arrT=arr;
		when(appd.findAll()).thenReturn(arr);
		AdministratorImpl ad=new AdministratorImpl(ele,par,cand,appd);
		ArrayList<ApplicationBean> arr2=ad.viewAllAdminPendingApplications();
		//System.out.println(arrT.remove(1).toString());
		assertEquals("View Pending Applications Failed",arrT,arr2);
		//assertNotEquals(arr, arr2);
	}
	

}
