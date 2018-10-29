package com.muditasoft.hibernateorm._03manytomany;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 *         Oct 29, 2018
 */
public class AddCoursesForStudentDemo {

	public static void main(String[] args) {
		// Create Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();
		
		try {
			// Start a transaction
			session.beginTransaction();
			
			// get the student from db
			Student student = session.get(Student.class, 1L);
			
			// print the student
			System.out.println("Student: " + student);
			System.out.println("Courses:");
			student.getCourses().forEach(System.out::println);
			
			// create more courses 
			Course c1 = new Course("Rubik's Cube - How to Speed Cube");
			Course c2 = new Course("Atari 2600 - Game Development");
			
			// add student to courses
			student.addCourse(c1);
			student.addCourse(c2);
			
			// save courses
			session.save(c1);
			session.save(c2);
			
			// Commit the transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
