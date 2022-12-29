package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.User;

public class TestUserRetrive {

	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		User u=session.get(User.class, 5);
		System.out.println(u);
		Address a=u.getAddr();
		System.out.println(a);
		tr.commit();
		session.close();
		

	}

}
