package com.niit.ElectronicVotingSystemServer.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.niit.ElectronicVotingSystemServer.bean.CredentialsBean;
import com.niit.ElectronicVotingSystemServer.dao.credentialsDAO;
import com.niit.ElectronicVotingSystemServer.util.DBUtil;

//@Service
public class credentialsDaoImpl implements credentialsDAO  {


	@Autowired
	credentialsDAO cd;

	

	public Optional<CredentialsBean> findById(String userId) {
		/*
		CredentialsBean user=null;//=new CredentialsBean();
		
		try {
			stmt = conn.createStatement( );
			rs = stmt.executeQuery("select * from evs_tbl_user_credentials where userid = '"+userId+"' ;");
			if(rs.next()) {
				user = new CredentialsBean(rs.getString("userid"),rs.getString("password"),rs.getString("userType"),rs.getInt("loginStatus"));
				System.out.println(user.toString());
			}
			else {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return user;
		*/
		return (cd.findById(userId));
	}
	
	public String createCredentials(CredentialsBean credentialsBean) {
		/*
		//conn=DBUtil.getDBConnection();
		try {
			stmt = conn.createStatement( );
			System.out.println(credentialsBean.toString());
			int z = stmt.executeUpdate("insert into evs_tbl_user_credentials(userid,password,usertype,loginstatus) values ('"+credentialsBean.getUserID()+"','"+credentialsBean.getPassword()+"','"+credentialsBean.getUserType()+"','"+credentialsBean.getLoginStatus()+"')");
			System.out.println(z);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return "U";
		*/
		try {
			System.out.println("CredentialDAO");
			System.out.println(cd);
			cd.save(credentialsBean);		
			return "SUCCESS";
		}
		catch(Exception  err) {
			err.printStackTrace();
			System.out.println(err);
		}
		return "FAIL";
	}
	
	public int deleteCredentials(ArrayList<String> credentials) {
		return -1;
	}
	
	public boolean updateCredentials(CredentialsBean credentialsBean) {
		/*
		//conn=DBUtil.getDBConnection();
		System.out.println("Updating User"+credentialsBean.toString());
		try {
 			stmt=conn.createStatement();
			System.out.println("Changing login status");
			int z=stmt.executeUpdate("update evs_tbl_user_credentials set loginstatus = '"+credentialsBean.getLoginStatus()+"' where userid = '"+credentialsBean.getUserID()+"' ;");
			System.out.println(z);
			return true;
		}
		catch(Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return false;
		*/
		//cd.findById(credentialsBean.getUserID());

		cd.deleteById(credentialsBean.getUserID());
		cd.save(credentialsBean);
		return true;
		
	}
	public ArrayList<CredentialsBean> findAll() {
		return (ArrayList<CredentialsBean>) cd.findAll();
		//return null;
	}



	@Override
	public List<CredentialsBean> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<CredentialsBean> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends CredentialsBean> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public <S extends CredentialsBean> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void deleteInBatch(Iterable<CredentialsBean> entities) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public CredentialsBean getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends CredentialsBean> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends CredentialsBean> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Page<CredentialsBean> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends CredentialsBean> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void delete(CredentialsBean entity) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAll(Iterable<? extends CredentialsBean> entities) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public <S extends CredentialsBean> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends CredentialsBean> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public <S extends CredentialsBean> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public <S extends CredentialsBean> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
}
