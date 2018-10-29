package com.muditasoft.hibernateorm._02onetomany.unidirectional;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 * Oct 29, 2018
 */
public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		// Get Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();
		
		try {
			// Start a transaction
			session.beginTransaction();
			
			// create a course
			Course course = new Course("Spring Framework - Beginner to Guru");
			
			// Add some reviews
			course.addReview(new Review("Great course. loved it!"));
			course.addReview(new Review("Cool course, job well done"));
			course.addReview(new Review("What a dumb course, you are an idiot!"));
			
			// save the course and leverage the cascade all
			session.save(course);
			
			// Commit the transaction
			session.getTransaction().commit();
			
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
