package com.niit.ElectronicVotingSystemServer.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.ElectronicVotingSystemServer.bean.CredentialsBean;
import com.niit.ElectronicVotingSystemServer.dao.credentialsDAO;
import com.niit.ElectronicVotingSystemServer.daoImpl.credentialsDaoImpl;

@Service
public class Authentication {
	@Autowired
	credentialsDAO cred;

	public boolean authenticate(CredentialsBean user) {
		try {
		CredentialsBean test=cred.findById(user.getUserID()).get(); 
		if(test.getPassword().equals(user.getPassword())) {
			if(test.getLoginStatus()==0) {
				//return changeLoginStatus(user,user.getLoginStatus());
				return true;
			}
			else {
				System.out.println("User already logged in.!");
				return changeLoginStatus(user,user.getLoginStatus());
			}
		}
		else {
			System.out.println("Password does not match!");
		}
		
		return false;
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
	}
	
	String autherize(String userId) {
		//credentialsDAO cred= new credentialsDaoImpl();
		try {
		CredentialsBean test=cred.findById(userId).get();
		System.out.println(test.toString());
		return test.getUserType();
		}catch(Exception err) {
			return "";
		}
		//return null;
	}
	
	boolean changeLoginStatus(CredentialsBean user, int loginStatus) {
		
		user.setLoginStatus((loginStatus+1)%2);
		//System.out.println();
		//credentialsDAO cred=new credentialsDaoImpl();
		CredentialsBean c=cred.saveAndFlush(user);
		if(c.getLoginStatus()==loginStatus) {
			return true;
		}
		return false;
		//return true;
	}
	
	public boolean alreadyLoggedIn(CredentialsBean user) {
		//credentialsDAO cred= new credentialsDaoImpl();
		CredentialsBean test=cred.findById(user.getUserID()).get(); 
		if(test.getLoginStatus()==1) {
			return true;
		}
		return false;
	}
	
	public boolean isAdminUser(CredentialsBean user) {
		//credentialsDAO cred= new credentialsDaoImpl();
		CredentialsBean test=cred.findById(user.getUserID()).get(); 
		if(test.getUserType().equals("A")) {
			return true;
		}
		return false;
		
	}

}
