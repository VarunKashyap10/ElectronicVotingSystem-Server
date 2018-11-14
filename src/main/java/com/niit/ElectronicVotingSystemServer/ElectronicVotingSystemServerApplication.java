package com.niit.ElectronicVotingSystemServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class ElectronicVotingSystemServerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ElectronicVotingSystemServerApplication.class, args);
		ApplicationContext  app=SpringApplication.run(ElectronicVotingSystemServerApplication.class, args);
		System.out.println("This is SprintBoot");
       // AbstractApplicationContext  app=new ClassPathXmlApplicationContext("pom.xml");
        String[] beans=app.getBeanDefinitionNames();
/*        for(String bean:beans) {	
        	System.out.println(bean);
        }*/
        System.out.println(beans.length);
        System.out.println("Welcome to Electronic Voting System");
	}
}
