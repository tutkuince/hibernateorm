package com.muditasoft.hibernateorm.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

/**
 * @author tutku ince
 *
 *         Oct 26, 2018
 */
public class HibernateConfig {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			// Create builder
			StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

			// // Hibernate settings equivalent to hibernate.cfg.xml's properties
			Map<String, Object> settings = new HashMap<>();

			Properties props = new Properties();
			try {
				props.load(new FileInputStream("src/main/resources/persistence-mysql.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Get JDBC Connection Properties
			String driver = props.getProperty("jdbc.driver");
			String url = props.getProperty("jdbc.url");
			String user = props.getProperty("jdbc.user");
			String password = props.getProperty("jdbc.password");

			// Set JDBC Connection Properties
			settings.put(Environment.DRIVER, driver);
			settings.put(Environment.URL, url);
			settings.put(Environment.USER, user);
			settings.put(Environment.PASS, password);

			// Get Connection Pool Properties
			String initialPoolSize = props.getProperty("connection.pool.initialPoolSize");
			String minPoolSize = props.getProperty("connection.pool.minPoolSize");
			String maxPoolSize = props.getProperty("connection.pool.maxPoolSize");
			String maxIdleTime = props.getProperty("connection.pool.maxIdleTime");

			// Set Connection Pool Properties
			settings.put(Environment.C3P0_ACQUIRE_INCREMENT, initialPoolSize);
			settings.put(Environment.C3P0_MIN_SIZE, minPoolSize);
			settings.put(Environment.C3P0_MAX_SIZE, maxPoolSize);
			settings.put(Environment.C3P0_TIMEOUT, maxIdleTime);

			// Get Hibernate Properties
			String dialect = props.getProperty("hbml.dialect");
			String sql = props.getProperty("hbml.SHOW_SQL");
			String session = props.getProperty("hbml.session");
			String hbm2ddl = props.getProperty("hbml.hbm2ddl");

			// Set Hibernate Properties
			settings.put(Environment.DIALECT, dialect);
			settings.put(Environment.SHOW_SQL, sql);
			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, session);
			settings.put(Environment.HBM2DDL_AUTO, hbm2ddl);

			// apply settings
			registryBuilder.applySettings(settings);

			// Build register
			registry = registryBuilder.build();

			// Create MetaDataSource
			MetadataSources metadataSources = new MetadataSources(registry);

			// Create MetaData
			Metadata metaData = metadataSources.buildMetadata();

			// Create SessionFactory
			sessionFactory = metaData.buildSessionFactory();
		}

		return sessionFactory;
	}

	public static void shutdown() {
		if (registry != null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
