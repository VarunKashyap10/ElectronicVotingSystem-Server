package com.niit.ElectronicVotingSystemServer.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.niit.ElectronicVotingSystemServer.dao.voterDAO;
import com.niit.ElectronicVotingSystemServer.util.DBUtil;


public class voterDaoImpl implements voterDAO {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	public String addVoter(String candidateid,String electionid,String voterid) {
		conn=DBUtil.getDBConnection();
		try {
			stmt = conn.createStatement( );
			int z = stmt.executeUpdate("insert into evs_tbl_voter_details(candidateid,electionid,voterid) values ('"+candidateid+"','"+electionid+"','"+voterid+"');");
			System.out.println(z);
			return "SUCCESS";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
			
		}

		return "FAIL";
	}
	
	public boolean checkVoterValidity(String voterid) {
		conn=DBUtil.getDBConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from evs_tbl_voter_details where voterid ='"+voterid+"';");
			if(!rs.next()) {
				return true;
			}
			else return false;
		}
		catch(Exception err) {
			System.out.println(err);
			err.printStackTrace();
		}
		return false;
	}
	
}
