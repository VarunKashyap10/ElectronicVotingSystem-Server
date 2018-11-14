package com.niit.ElectronicVotingSystemServer.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niit.ElectronicVotingSystemServer.bean.CandidateBean;

@Repository
public interface candidateDAO extends JpaRepository<CandidateBean,String> {

}
