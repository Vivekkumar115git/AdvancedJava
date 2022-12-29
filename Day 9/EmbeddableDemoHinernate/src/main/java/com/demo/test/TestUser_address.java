package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;

import com.demo.beans.User;

public class TestUser_address {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction  tr=session.beginTransaction();
		///these atr in transient state
		Address addr=new Address("baner","pune","Maharashtra");
		User u=new User("Revati","Khadilkar","rev.gmail.com",addr);
		User u1=new User("Rajan","Khadilkar","rojrocks.gmail.com",addr);
		// convert it into persistent state
		session.save(u);
		session.save(u1);
		tr.commit();
		session.close();
		
		

	}

}
