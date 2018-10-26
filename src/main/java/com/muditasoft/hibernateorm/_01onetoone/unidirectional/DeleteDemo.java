package com.muditasoft.hibernateorm._01onetoone.unidirectional;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 *         Oct 26, 2018
 */
public class DeleteDemo {
	public static void main(String[] args) {

		// Create Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();

			// get instructor by primary key / id
			Long id = 1L;
			Instructor instructor = session.get(Instructor.class, id);

			System.out.println("Found instructor: " + instructor);

			// delete the instructor
			if (instructor != null) {
				System.out.println("Deleting ==>> " + instructor);

				// NOTE: will also delete associated "details" object because of CascadeType.ALL
				session.delete(instructor);
			}

			// commit transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
