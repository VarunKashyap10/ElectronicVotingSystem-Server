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

import com.niit.ElectronicVotingSystemServer.bean.ProfileBean;
import com.niit.ElectronicVotingSystemServer.dao.profileDAO;
import com.niit.ElectronicVotingSystemServer.util.DBUtil;

//@Service
public class profileDaoImpl implements profileDAO {

	@Autowired
	profileDAO pd;
	
	
	public String createProfile(ProfileBean profileBean) {
		/*
		conn=DBUtil.getDBConnection();
		try {
			stmt = conn.createStatement( );
			int z = stmt.executeUpdate("insert into evs_tbl_user_profile(userid,firstname,lastname,dateofbirth,gender,street,location,city,state,pincode,mobileno,emailid) values ('"+profileBean.getUserID()+"','"+profileBean.getFirstName()+"','"+profileBean.getLastName()+"','"+profileBean.getDateOfBirth() +"','"+profileBean.getGender()+"','"+profileBean.getStreet()+"','"+profileBean.getLocation()+"','"+profileBean.getCity()+"','"+profileBean.getState()+"','"+profileBean.getPincode()+"','"+profileBean.getMobileNo()+"','"+profileBean.getEmailID()+"');");
			System.out.println(z);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception err) {
			err.printStackTrace();
		}

		return "U";
		*/
		System.out.println(profileBean.toString());
		pd.save(profileBean);
		return "SUCCESS";
	}
	public int deleteProfile(ArrayList<String> profiles) {
		return -1;
	}
	public boolean updateProfile(ProfileBean rofileBean) {
		return false;
	}
	public Optional<ProfileBean> findById(String profile) {
		return null;
	}
	public ArrayList<ProfileBean> findAll(){
		return null;
	}
	@Override
	public List<ProfileBean> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ProfileBean> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends ProfileBean> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends ProfileBean> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteInBatch(Iterable<ProfileBean> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ProfileBean getOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends ProfileBean> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends ProfileBean> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<ProfileBean> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends ProfileBean> S save(S entity) {
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
	public void delete(ProfileBean entity) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll(Iterable<? extends ProfileBean> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends ProfileBean> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends ProfileBean> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends ProfileBean> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public <S extends ProfileBean> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
}
