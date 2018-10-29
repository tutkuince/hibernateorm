package com.muditasoft.hibernateorm._02onetomany.bidirectional;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 *         Oct 29, 2018
 */
public class CreateCoursesDemo {

	public static void main(String[] args) {

		// Create Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();

		try {
			// Start a transaction
			session.beginTransaction();

			// Get the instructor from db
			Instructor instructor = session.get(Instructor.class, 1L);

			// Create some courses
			Course c1 = new Course("Air Guitar - The Ultimate Guide");
			Course c2 = new Course("The Paintball Masterclass");
			Course c3 = new Course("Spring Framework - Beginner to Guru");

			// add courses to instructor
			instructor.addCourse(c1);
			instructor.addCourse(c2);
			instructor.addCourse(c3);

			// save the courses
			session.save(c1);
			session.save(c2);
			session.save(c3);
			
			// Commit transaction
			session.getTransaction().commit();

			System.out.println("DONE");
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
