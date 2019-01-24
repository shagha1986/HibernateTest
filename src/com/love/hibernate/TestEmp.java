package com.love.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestEmp {

	public static void main(String[] args) {
	
		SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		try {
			Employee TmpEmp = new Employee(10,29,"Gustav");
			session.beginTransaction();
			session.save(TmpEmp);
			session.getTransaction().commit();
		}
		finally {
			sessionfactory.close();
		}

	}

}
