package com.muditasoft.hibernateorm._02onetomany.bidirectional;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 *         Oct 29, 2018
 */
public class CreateInstructorDemo {

	public static void main(String[] args) {

		// Create Session
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();

		try {
			// Create the objects
			Instructor instructor = new Instructor("Tutku", "Ince", "incetutku@gmail.com");

			InstructorDetails instructorDetails = new InstructorDetails("tutkuince", "Video Games");

			// associate the objects
			instructor.setInstructorDetails(instructorDetails);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor 
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("DONE");
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
