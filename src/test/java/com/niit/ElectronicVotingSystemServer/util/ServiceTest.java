package com.niit.ElectronicVotingSystemServer.util;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.niit.ElectronicVotingSystemServer.bean.CredentialsBean;
import com.niit.ElectronicVotingSystemServer.bean.ProfileBean;

public class ServiceTest {
	@Autowired
	User user;


	//@Autowired
	//credentialsDAO cred;
	


	@Test
	public void testRegister() {
		ProfileBean pb=new ProfileBean("Varun","Kashyap","Male",Date.valueOf(LocalDate.parse("1997-03-30")),"Hyd","Mallapur","Chengicherla","Telangana","500076","8790213645","kvarun10@gmail.com","qwerty1");
		String result=user.resgister(pb);
		assertEquals("Register Failed","SUCCESS",result);
	}
	
	@Test
	public void testLogout() {
		CredentialsBean cb= new CredentialsBean();
		cb.setUserID("VK9999");
		cb.setPassword("qwerty1");
		cb.setLoginStatus(0);
		boolean result=user.logout(cb.getUserID());
		assertEquals("Logout Failed",true,result);
	}
//	@Test
//	public void testChangePassword() {
//		CredentialsBean cb= new CredentialsBean();
//		cb.setUserID("VK9999");
//		cb.setPassword("qwerty1");
//		cb.setLoginStatus(0);
//		String result=user.changePassword(cb , "qwerty1");
//		assertEquals("Password Change Failed","SUCCESS",result);
//	}

}
