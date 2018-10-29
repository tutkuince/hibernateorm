package com.muditasoft.hibernateorm._03manytomany;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 *         Oct 29, 2018
 */
public class DeleteCourseDemo {

	public static void main(String[] args) {
		// Create Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();
		
		try {
			// Start a transaction
			session.beginTransaction();
			
			// get the course
			Course course = session.get(Course.class, 2L);
			
			// delete the course
			System.out.println("Deleting coures: " + course);
			
			session.delete(course);
			
			// Commit the transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
