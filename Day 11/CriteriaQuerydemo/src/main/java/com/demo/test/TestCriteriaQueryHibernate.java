package com.demo.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;


import com.demo.beans.Product;

public class TestCriteriaQueryHibernate {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(Product.class);
		List<Product> plist=cr.list();
		//String str="select p from Product p where p.qty>23";
		plist.forEach(x->{System.out.println(x);});
		System.out.println("*******************************************************");
		//to find products with qty<50
		
		plist=cr.list();
		//String str="select p from Product p where p.qty>23";
		plist.forEach(x->{System.out.println(x);});
		System.out.println("*******************************************************");
		Criterion pricegt=Restrictions.gt("price",1000.00);
		Criterion qtylt=Restrictions.lt("qty",50);
		Criteria cr1=session.createCriteria(Product.class);
		LogicalExpression expr=Restrictions.or(pricegt,qtylt);
		cr1.add(expr);
		plist=cr1.list();
		plist.forEach(x->{System.out.println(x);});
		System.out.println("*******************************************************");
		cr1.setFirstResult(0);
		cr1.setMaxResults(2);
		plist=cr1.list();
		plist.forEach(x->{System.out.println(x);});
		
		//using JPQL
		System.out.println("using JPQL");
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<Product> cr2=cb.createQuery(Product.class);
		Root<Product> root=cr2.from(Product.class);
		Query q=session.createQuery(cr2.select(root));
	    plist=q.getResultList();
	    plist.forEach(x->{System.out.println(x);});

		
	}

}
