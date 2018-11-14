package com.niit.ElectronicVotingSystemServer.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.ElectronicVotingSystemServer.bean.ElectionBean;
import com.niit.ElectronicVotingSystemServer.dao.electionDAO;
import com.niit.ElectronicVotingSystemServer.util.DBUtil;


//@Service
public class electionDaoImpl {
	@Autowired
	electionDAO eled;
//	Connection conn;
//	Statement stmt;
//	ResultSet rs;
	public String createElection(ElectionBean electionBean) {
		/*
		conn=DBUtil.getDBConnection();
		try {
			stmt = conn.createStatement( );
			int z = stmt.executeUpdate("insert into evs_tbl_election(electionid,name,electiondate,district,constituency,countingdate) values ('"+electionBean.getElectionID()+"','"+electionBean.getName()+"','"+electionBean.getElectionDate()+"','"+electionBean.getDistrict()+"','"+electionBean.getConstituency()+"','"+electionBean.getCountingDate()+"')");
			System.out.println(z);
			return "SUCCESS";
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return "FAIL";
		*/
		try {
			eled.save(electionBean);
			return "SUCCESS";
		}catch(Exception err) {
			return "FAIL";
		}
		
	}
	public int deleteElection(ElectionBean e) {
		/*
		conn=DBUtil.getDBConnection();
		
		for(String elecId: elections) {
		try {
			stmt=conn.createStatement();
			int z=stmt.executeUpdate("delete from evs_tbl_election where electionid = '"+elecId+"';");
			return z;
		}catch(Exception err) {
			System.out.println(err);
		}
		
		}
		return 0;
		*/
		try {
			eled.delete(e);	
			return 1;
		}catch(Exception err) {
			err.printStackTrace();
			System.out.println(err);
			return -1;
		}
	}
	public boolean updateElection(ElectionBean electionBean) {
		return false;
	}
	public Optional<ElectionBean> findById(String electionId) {
		/*
		conn=DBUtil.getDBConnection();
		ElectionBean elec=new ElectionBean();
		try {
			stmt = conn.createStatement( );
			rs = stmt.executeQuery("select * from evs_tbl_election where userid = '"+electionId+"' ;");
			if(rs.next()) {
				elec = new ElectionBean(rs.getString("electionid"),rs.getString("name"),rs.getDate("electiondate"),rs.getString("district"),rs.getString("constituency"),rs.getDate("countingdate"));
				System.out.println(elec.toString());
			}
		}catch(Exception err) {
			System.out.println(err);
		}
		return null;
		*/
		try {
			return eled.findById(electionId);
		}catch(Exception err) {
			err.printStackTrace();
			return null;
		}
	}
	public ArrayList<ElectionBean> findAll(){
		/*
		conn=DBUtil.getDBConnection();
		ArrayList<ElectionBean> arr=new ArrayList<ElectionBean>();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from evs_tbl_election; ");
			while(rs.next()) {
				arr.add(new ElectionBean(rs.getString("electionid"),rs.getString("name"),rs.getDate("electiondate"),rs.getString("district"),rs.getString("constituency"),rs.getDate("countingdate")));
			}
			return arr;
		}catch(Exception err) {
			System.out.println(err);
		}
		return null;
		*/
		try {
			return (ArrayList<ElectionBean>) eled.findAll();
		}catch(Exception err) {
			err.printStackTrace();
			return null;
		}
	}

}
