package com.love.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyTest {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			System.out.println("saving 3 Objects");
			Employee emp1 = new Employee(11,"Diana");
			Employee emp2 = new Employee(31,"Roksana");
			Employee emp3 = new Employee(18,"Miriam");

			session.beginTransaction();
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.getTransaction().commit();
			System.out.println("Save is Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
