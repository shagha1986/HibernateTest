package com.love.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadEmployeeHQL {

	public static void main(String[] args) {

		SessionFactory sessionfactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session = sessionfactory.getCurrentSession();
		try {

			session.beginTransaction();

			List<Employee> emplist = session.createQuery("from Employee").getResultList();
			System.out.println("List of Employees: ");
			showEmps(emplist);
			System.out.println("Employees with the name Roksana");
			emplist = session.createQuery("from Employee e where e.name = 'Roksana'").getResultList();
			showEmps(emplist);

			session.getTransaction().commit();
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
