package com.muditasoft.hibernateorm._04fetchtypes.eagerloading;

import com.muditasoft.hibernateorm.config.HibernateConfig;

import org.hibernate.Session;

/**
 * @author tutku ince
 *
 *         Oct 29, 2018
 */
public class EagerDemo {
	public static void main(String[] args) {
		// Create Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();

		try {
			// Begin a transaction
			
			// Get the instructor from db
			Instructor instructor = session.get(Instructor.class, 1L);

			System.out.println("Instructor: " + instructor);

			// get courses for the instructor
			instructor.getCourses().forEach(System.out::println);

			// commit the transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
