package com.niit.ElectronicVotingSystemServer.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.niit.ElectronicVotingSystemServer.bean.CandidateBean;
import com.niit.ElectronicVotingSystemServer.dao.candidateDAO;
import com.niit.ElectronicVotingSystemServer.util.DBUtil;



public class candidateDaoImpl {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public String createCandidate(CandidateBean candidateBean) {
		conn=DBUtil.getDBConnection();
		try {
			stmt = conn.createStatement( );
			int z = stmt.executeUpdate("insert into evs_tbl_candidate(candidateid,name,electionid,partyid,district,constituency,dateofbirth,mobileno,address,emailid) values ('"+candidateBean.getCandidateID()+"','"+candidateBean.getName()+"','"+candidateBean.getElectionID()+"','"+candidateBean.getPartyID()+"','"+candidateBean.getDistrict()+"','"+candidateBean.getConstituency()+"','"+candidateBean.getDateOfBirth()+"','"+candidateBean.getMobileNo()+"','"+candidateBean.getAddress()+"','"+candidateBean.getEmailID()+"');");
			System.out.println(z);
			return "SUCCESS";
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return "FAIL";
		
	}
	public int deleteCandidate(ArrayList<String> candidates) {
		return 0;
		
	}
	public boolean updateCandidate(CandidateBean candidateBean) {
		return false;
		
	}
	public CandidateBean findById(String candidate) {
		return null;
		
	}
	//(String name, String eleId,String  partyId, String dist,String cons, Date dob,String mobile,String address,String email
	public ArrayList<CandidateBean> findAll(){
		conn=DBUtil.getDBConnection();
		ArrayList<CandidateBean> arr=new ArrayList<CandidateBean>();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from evs_tbl_candidate; ");
			while(rs.next()) {
				arr.add(new CandidateBean(rs.getString("candidateid"),rs.getString("name"),rs.getString("electionid"),rs.getString("partyid"),rs.getString("constituency"),rs.getDate("dateofbirth"),rs.getString("mobileno"),rs.getString("address"),rs.getString("emailid")));
			}
			return arr;
		}catch(Exception err) {
			System.out.println(err);
		}
		return null;
		
	}

}
