package com.niit.ElectronicVotingSystemServer.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.niit.ElectronicVotingSystemServer.bean.PartyBean;
import com.niit.ElectronicVotingSystemServer.dao.partyDAO;
import com.niit.ElectronicVotingSystemServer.util.DBUtil;



public class partyDaoImpl {

	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public String createParty(PartyBean partyBean) {
		conn=DBUtil.getDBConnection();
		try {
			stmt = conn.createStatement( );
			System.out.println(partyBean.toString());
			int z = stmt.executeUpdate("insert into evs_tbl_party (partyid,name,leader,symbol) values ('"+partyBean.getPartyID()+"','"+partyBean.getName()+"','"+partyBean.getLeader()+"','"+partyBean.getSymbol()+"');");
			System.out.println(z);
			return "SUCCESS";

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}catch(Exception err) {
			err.printStackTrace();
		}

		return "FAIL";
	}
	public int deleteParty(ArrayList<String> partys) {
		return 0;
	}
	public boolean updateParty(PartyBean partyBean) {
		return false;
	}
	public PartyBean findById(String party) {
		PartyBean part=null;//=new CredentialsBean();
		conn=DBUtil.getDBConnection();
		try {
			stmt = conn.createStatement( );
			rs = stmt.executeQuery("select * from evs_tbl_party where userid = '"+party+"' ;");
			if(rs.next()) {
				part = new PartyBean(rs.getString("partyid"),rs.getString("name"),rs.getString("leader"),rs.getString("symbol"));
				System.out.println(part.toString());
			}
			else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return part;
	}
	public ArrayList<PartyBean> findAll(){
		conn=DBUtil.getDBConnection();
		ArrayList<PartyBean> arr=new ArrayList<PartyBean>();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery("select * from evs_tbl_party; ");
			while(rs.next()) {
				arr.add(new PartyBean(rs.getString("partyid"),rs.getString("name"),rs.getString("leader"),rs.getString("symbol")));
			}
			return arr;
		}catch(Exception err) {
			System.out.println(err);
		}
		return null;
	}
}
