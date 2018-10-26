package com.muditasoft.hibernateorm._01onetoone.bidirectional;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 *         Oct 26, 2018
 */
public class GetInstructorDetailsDemo {
	public static void main(String[] args) {

		// Create Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();

		try {
			// start a transaction
			session.beginTransaction();
			
			// get the instructor details 
			Long id = 1L;
			InstructorDetails instructorDetails = session.get(InstructorDetails.class, id);
			
			// print the instructor details
			System.out.println("Instructor Details: " + instructorDetails);
			
			// print the associated instructor
			System.out.println("Instructor: " + instructorDetails.getInstructor());

			// commit transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
