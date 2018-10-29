package com.muditasoft.hibernateorm._04fetchtypes.lazyloading;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 * Oct 29, 2018
 */
public class LazyDemo {

	public static void main(String[] args) {
		// Get a Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();
		
		try {
			// Start a transaction
			session.beginTransaction();
			
			// Get a Instructor
			Instructor instructor = session.get(Instructor.class, 1L);
			System.out.println("Instructor: " + instructor);
			
			// get courses for the instructor
			instructor.getCourses().forEach(System.out::println);
			
			// Commit the transaction
			session.getTransaction().commit();
			
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
