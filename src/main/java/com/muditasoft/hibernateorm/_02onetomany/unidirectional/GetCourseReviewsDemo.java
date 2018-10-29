package com.muditasoft.hibernateorm._02onetomany.unidirectional;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 * Oct 29, 2018
 */
public class GetCourseReviewsDemo {
	public static void main(String[] args) {
		// Create Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();
		
		try {
			// Start a transaction
			session.beginTransaction();
			
			// Get the course
			Course course = session.get(Course.class, 1L);
			
			// print the course
			System.out.println("Course: " + course);
			
			// print the course reviews
			course.getReviews().forEach(r -> System.out.println(r));
			
			// Commit the transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
