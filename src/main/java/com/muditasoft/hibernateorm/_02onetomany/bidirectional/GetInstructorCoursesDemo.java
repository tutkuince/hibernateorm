package com.muditasoft.hibernateorm._02onetomany.bidirectional;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 * Oct 29, 2018
 */
public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		// Get Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();
		
		try {
			// Start a transaction
			session.beginTransaction();
			
			// Get the Instructor
			Instructor instructor = session.get(Instructor.class, 1L);
			
			// Get the courses for the instructor
			instructor.getCourses().forEach(System.out::println);
					
			// Commit transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
