package com.niit.ElectronicVotingSystemServer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.stereotype.Repository;

import com.niit.ElectronicVotingSystemServer.bean.CredentialsBean;
import com.niit.ElectronicVotingSystemServer.dao.credentialsDAO;

@Repository
@DataJpaTest
public class credentialsDAOTest {
	@Autowired
	credentialsDAO cred;
	@Autowired
	TestEntityManager entityManager;
	@Test
	public void whenFindByName_returnCredentials() {
		CredentialsBean c=new CredentialsBean();
		c.setUserID("VK9999");
		c.setPassword("qwerty1");
		entityManager.persist(c);
		entityManager.flush();
		
		CredentialsBean found=cred.findById(c.getUserID()).get();
		assertEquals(found.getPassword(),c.getPassword());
		
	}

}
