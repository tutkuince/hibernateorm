package com.muditasoft.hibernateorm._03manytomany;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 *         Oct 29, 2018
 */
public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		// Create Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();
		
		try {
			// Start a transaction
			session.beginTransaction();
			
			// Create a course
			Course course = new Course("Hibernate for Beginners");
			
			// save the course
			System.out.println("\nSaving the course . . . ");
			session.save(course);
			System.out.println("Saved the course: " + course);
			
			// create the students
			Student std1 = new Student("Tutku", "Ince", "incetutku@gmail.com");
			Student std2 = new Student("Emin", "Koklu", "kokluemin@gmail.com");
			
			
			// add the students to the course
			course.addStudent(std1);
			course.addStudent(std2);
			
			// save the students
			System.out.println("\nSaving students . . . ");
			session.save(std1);
			session.save(std2);
			
			// Commit the transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
