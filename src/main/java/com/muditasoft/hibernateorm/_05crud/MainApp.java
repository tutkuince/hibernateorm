package com.muditasoft.hibernateorm._05crud;

import org.hibernate.Session;

import com.muditasoft.hibernateorm._05crud.model.Department;
import com.muditasoft.hibernateorm._05crud.model.Employee;
import com.muditasoft.hibernateorm._05crud.model.EmployeeDetails;
import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 *         Oct 30, 2018
 */
public class MainApp {
	public static void main(String[] args) {
		// Create Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();

		try {
			// Create Employee
			Employee employee = new Employee("Tutku", "Ince");

			// Create Employee Details
			EmployeeDetails employeeDetails = new EmployeeDetails("incetutku@gmail.com", "4713807");

			// Create Departments
			Department d1 = new Department("IT");
			Department d2 = new Department("Sales");
			Department d3 = new Department("Customer Relations");

			// Start a transaction
			session.beginTransaction();

			// Save departments
			session.save(d1);
			session.save(d2);
			session.save(d3);

			// associate the objects
			employee.setEmployeeDetails(employeeDetails);
			employee.setDepartment(d1);

			// Save Employee
			session.save(employee);

			// Commit the transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
