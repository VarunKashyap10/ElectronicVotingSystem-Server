package com.niit.ElectronicVotingSystemServer.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.niit.ElectronicVotingSystemServer.bean.ApplicationBean;
import com.niit.ElectronicVotingSystemServer.dao.applicationDAO;
import com.niit.ElectronicVotingSystemServer.util.DBUtil;



public class applicationDaoImpl {
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public String createApplication(ApplicationBean applicationBean) {
		return null;
	}
	public int deleteApplication(ArrayList<String> applications) {
		return 0;
	}
	public boolean updateApplication(ApplicationBean applicationBean) {
		return false;
	}
	public ApplicationBean findById(String application) {
		ApplicationBean app=null;//=new CredentialsBean();
		conn=DBUtil.getDBConnection();
		try {
			stmt = conn.createStatement( );
			rs = stmt.executeQuery("select * from evs_tbl_party where userid = '"+application+"' ;");
			if(rs.next()) {
				app = new ApplicationBean(rs.getString("userid"),rs.getString("constituency"),rs.getInt("passedstatus"),rs.getInt("approvedstatus"),rs.getString("voteid"));
				System.out.println(app.toString());
			}
			else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return app;
		}
	public ArrayList<ApplicationBean> findAll(){
		return null;
	}
}
