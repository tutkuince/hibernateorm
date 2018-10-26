package com.muditasoft.hibernateorm._01onetoone.bidirectional;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 *         Oct 26, 2018
 */
public class CreateDemo {
	public static void main(String[] args) {

		// Create Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();

		try {
			// Create the objects
			Instructor instructor = new Instructor("Tutku", "Ince", "incetutku@gmail.com");

			InstructorDetails instructorDetails = new InstructorDetails("Tutku Ince", "Coding");

			// associate the objects
			instructor.setInstructorDetails(instructorDetails);

			// start a transaction
			session.beginTransaction();

			// save the instructor.
			// NOTE : this will also save the details object because of CascadeType.ALL
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);

			// commit transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
