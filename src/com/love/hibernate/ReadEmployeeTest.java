package com.love.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployeeTest {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		try {

			session.beginTransaction();
			List<Object[]> emplist = session.createNativeQuery("select * from emp").list();
			for (Object[] emp : emplist) {
				Integer id = (Integer) emp[0];
				String name = (String) emp[1];
				Integer age = (Integer) emp[2];
				System.out.println(" employee " + id + " is " + name + "--" + age);
			}

			session.getTransaction().commit();
		} finally {
			sessionfactory.close();
		}

	}

}
