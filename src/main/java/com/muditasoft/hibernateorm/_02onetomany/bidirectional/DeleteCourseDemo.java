package com.muditasoft.hibernateorm._02onetomany.bidirectional;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 *         Oct 29, 2018
 */
public class DeleteCourseDemo {

	public static void main(String[] args) {
		// Get a Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();

		try {
			// Start a transaction
			session.beginTransaction();

			// Get a Course
			Course course = session.get(Course.class, 1L);

			if (course != null) {
				// Delete selected Course
				System.out.println("Deleting course: " + course);
				session.delete(course);
			}

			// Commit the transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
