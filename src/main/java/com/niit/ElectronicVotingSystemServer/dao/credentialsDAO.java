package com.niit.ElectronicVotingSystemServer.dao;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niit.ElectronicVotingSystemServer.bean.CredentialsBean;

@Repository
public interface credentialsDAO extends JpaRepository<CredentialsBean,String>{
	
	public Optional<CredentialsBean> findById(String id);

}
