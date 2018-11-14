package com.niit.ElectronicVotingSystemServer.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niit.ElectronicVotingSystemServer.bean.ResultBean;

@Repository
public interface resultDAO extends JpaRepository<ResultBean, String>{
	
	
}
