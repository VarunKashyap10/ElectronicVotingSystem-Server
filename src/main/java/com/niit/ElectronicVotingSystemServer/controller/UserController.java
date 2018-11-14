package com.niit.ElectronicVotingSystemServer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.ElectronicVotingSystemServer.bean.CredentialsBean;
import com.niit.ElectronicVotingSystemServer.bean.ProfileBean;
import com.niit.ElectronicVotingSystemServer.dao.credentialsDAO;
import com.niit.ElectronicVotingSystemServer.util.User;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	ProfileBean profileNew;
	@Autowired
	CredentialsBean cred;
	@Autowired
	User user;
	@Autowired
	credentialsDAO cd;
	UserController(){
		System.out.println("UserController");
	}
	@GetMapping
	public String welcome() {
		System.out.println("Default User Controller");
		return "Welcome to EVS!";
	}
	
	@PostMapping("/login")
	public CredentialsBean userLogin(@RequestBody CredentialsBean cred) {
		System.out.println("Login Route");
		System.out.println(cred.toString());
		String log= user.login(cred);
		System.out.println(log);
		return cd.findById(cred.getUserID()).get();
	}
	
	@PostMapping("/register")
	public String userRegister(@RequestBody ProfileBean profile) {
		System.out.println("Register Route");
		//ProfileBean profileNew=new ProfileBean(profile.getFirstName(),profile.getLastName(),profile.getGender(),profile.getDateOfBirth(),profile.getCity(),profile.getLocation(),profile.getStreet(),profile.getState(),profile.getPincode(),profile.getMobileNo(),profile.getEmailID(),profile.getPassword());
		profileNew.setFirstName(profile.getFirstName());
		profileNew.setLastName(profile.getLastName());
		profileNew.setGender(profile.getGender());
		profileNew.setDateOfBirth(profile.getDateOfBirth());
		profileNew.setCity(profile.getCity());
		profileNew.setLocation(profile.getLocation());
		profileNew.setStreet(profile.getStreet());
		profileNew.setState(profile.getState());
		profileNew.setUserID(profileNew.generateUID(profileNew.getFirstName()));
		profileNew.setPincode(profile.getPincode());
		profileNew.setMobileNo(profile.getMobileNo());
		cred.setUserID(profileNew.getUserID());
		cred.setPassword(profileNew.getPassword());
		cred.setLoginStatus(0);
		cred.setUserType("U");
		cd.save(cred);
		return user.resgister(profileNew);
	}
	
	@PutMapping("/changePassword/{newPass}")
	public CredentialsBean userChangePassword(@Valid @RequestBody CredentialsBean cred, @PathVariable String newPass) {
		System.out.println(cred.toString());
		return user.changePassword(cred, newPass);
	}
	
	@GetMapping("/logout/{userId}")
	public String userLogout(@PathVariable String userId) {
		if(user.logout(userId))
			return "SUCCESS";
		else
			return "FAIL";
	}
	
	@GetMapping("/getCredentials/{userid}")
	public CredentialsBean getCredentials(@PathVariable String userid) {
		return cd.findById(userid).get();
	}
}
