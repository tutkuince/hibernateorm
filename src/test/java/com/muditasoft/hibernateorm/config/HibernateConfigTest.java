package com.muditasoft.hibernateorm.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author tutku ince
 *
 * Oct 26, 2018
 */
public class HibernateConfigTest {

	@Test
	void sessionFactoryIsNotNull() throws Exception {
		assertNotNull(HibernateConfig.getSessionFactory(), () -> "SessionFactory cannot be null");
	}
}
