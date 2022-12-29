package com.demo.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Address;
import com.demo.beans.User;

public class TestManyToMany {
	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		User u1 = new User();
		u1.setFname("Parag");
		u1.setLname("Nukalwar");
		User u2 = new User();
		u2.setFname("Shreyas");
		u2.setLname("Chaudhari");
		Set<User> userset = new HashSet<>();
		userset.add(u1);
		userset.add(u2);
		Address a1 = new Address("Wakad","Pune","Maharashtra",userset);
		Address a2 = new Address("Hinjewadi","Pune","Maharashtra",userset);
		Set<Address> addrset = new HashSet<>();
		addrset.add(a1);
		addrset.add(a2);
		u1.setAddrset(addrset);
		u2.setAddrset(addrset);
		session.save(u1);
		session.save(u2);
		tr.commit();
		session.close();
		
	}

}
