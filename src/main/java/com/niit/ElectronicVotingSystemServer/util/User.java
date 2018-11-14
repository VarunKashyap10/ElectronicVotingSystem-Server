package com.niit.ElectronicVotingSystemServer.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.ElectronicVotingSystemServer.bean.CredentialsBean;
import com.niit.ElectronicVotingSystemServer.bean.ProfileBean;
import com.niit.ElectronicVotingSystemServer.dao.credentialsDAO;
import com.niit.ElectronicVotingSystemServer.dao.profileDAO;
import com.niit.ElectronicVotingSystemServer.daoImpl.credentialsDaoImpl;
import com.niit.ElectronicVotingSystemServer.daoImpl.profileDaoImpl;

@Service
public class User {
	@Autowired
	profileDAO pd;
//	@Autowired
//	credentialsDAO cd;
	@Autowired
	Authentication a;
	@Autowired
	credentialsDAO cred;
	
	public User(profileDAO pd, credentialsDAO cred,Authentication a){
		this.pd=pd;
		this.cred=cred;
		this.a=a;
	}
	
	public String login(CredentialsBean credentialsBean) {
		System.out.println("Login");
		try {
			//Authentication a=new Authentication();
			if(a.authenticate(credentialsBean)) {
				System.out.println("User Authenticated");
				String temp=a.autherize(credentialsBean.getUserID());
				System.out.println("User type returned -"+temp );
				switch(temp) {
				case "A":
					return "A"; 
				case "E":
					return "E";
				case "U":
					return "U";
				default:
					return "ERROR";					
				}
			}
			return "FAIL";
		}
		catch(Exception err) {
			System.out.println(err);
			err.printStackTrace();
			return "FAIL";
		}
	}
	
	public boolean logout(String userId) {
		try {
			// credentialsDaoImpl cred=new credentialsDaoImpl();
			CredentialsBean user=cred.findById(userId).get();
			user.toString();
			//Authentication auth=new Authentication();
			a.changeLoginStatus(user, user.getLoginStatus());
			return true;
		}catch(Exception err) {
			System.out.println(err);
			err.printStackTrace();
		}
		return false;
	}
	
	public CredentialsBean changePassword(CredentialsBean user, String newPass) {
		if(user.getLoginStatus()==1) {
			user.setPassword(newPass);
			return user;
		}
		
		return null;
	}
	
	public String resgister(ProfileBean profileBean) {
		System.out.println(profileBean.toString());
		//profileDaoImpl pd=new profileDaoImpl();
		//cd.createCredentials(new CredentialsBean(profileBean.getUserID(),profileBean.getPassword()));
		
		//Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			pd.save(profileBean);
			return "SUCCESS";
		}catch(Exception err) {
			err.printStackTrace();
			return "FAIL";
		}
	}

}
