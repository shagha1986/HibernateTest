package com.love.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateEmployeeHQL2 {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		
		try {
//			Session session = sessionfactory.getCurrentSession();
//			session.beginTransaction();
//			int empId = 10;
//			Employee emp = session.get(Employee.class, empId);
//			System.out.println("updating employee ");
//			emp.setName("Michael");
//			session.getTransaction().commit();
//			System.out.println("Done!");
			
			//update for Age 
			Session sessionUpdate = sessionfactory.getCurrentSession();
			sessionUpdate.beginTransaction();
			sessionUpdate.createQuery("update Employee set age = 29 where id= 10").executeUpdate();
			System.out.println("updating employees ");
		
			sessionUpdate.getTransaction().commit();
			System.out.println("Done!");
			
			
			
		} finally {
			sessionfactory.close();
		}

	}

	private static void showEmps(List<Employee> emplist) {
		for (Employee emps : emplist) {
			System.out.println("id " + emps.getId() + " name " + emps.getName() + " Age " + emps.getAge());
		}
	}

}
