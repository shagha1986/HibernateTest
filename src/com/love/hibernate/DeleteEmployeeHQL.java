package com.love.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteEmployeeHQL {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		try {

			session.beginTransaction();
			int id = 1;
			Employee emp = session.get(Employee.class,id);
			session.delete(emp);
			//session.createQuery("delete from Employee where id = 1").executeUpdate();
			
			System.out.println("deleting employee with id=1 ");
		
			session.getTransaction().commit();
			System.out.println("deleted!");
			
			session.getTransaction().commit();
		} finally {
			sessionfactory.close();
		}

	}

	

}
