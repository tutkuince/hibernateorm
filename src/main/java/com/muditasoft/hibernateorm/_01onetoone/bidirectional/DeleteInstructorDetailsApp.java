package com.muditasoft.hibernateorm._01onetoone.bidirectional;

import org.hibernate.Session;

import com.muditasoft.hibernateorm.config.HibernateConfig;

/**
 * @author tutku ince
 *
 *         Oct 26, 2018
 */
public class DeleteInstructorDetailsApp {

	public static void main(String[] args) {
		Session session = HibernateConfig.getSessionFactory().getCurrentSession();

		try {
			// begin transaction
			session.beginTransaction();

			Long id = 1L;
			InstructorDetails instructorDetails = session.get(InstructorDetails.class, id);

			// Print the instructor
			System.out.println("Instructor: " + instructorDetails.getInstructor());

			// Print the instructor details
			System.out.println("Instructor Details: " + instructorDetails);

			// now let's delete the instructor details
			System.out.println("Deleting instructor details ==>>");

			// remove the associated object reference break bi-directional link
			instructorDetails.getInstructor().setInstructorDetails(null);

			// delete instructor details
			session.delete(instructorDetails);

			// commit transaction
			session.getTransaction().commit();
		} finally {
			HibernateConfig.shutdown();
		}
	}
}
