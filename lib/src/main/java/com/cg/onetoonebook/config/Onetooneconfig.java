package com.cg.onetoonebook.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.cg.onetoonebook.entity.Book;
import com.cg.onetoonebook.entity.Author;


public class Onetooneconfig {
	//declare the hibernate and db properties
		private static SessionFactory sessionFactory;//factory (group of db connections)
		public static SessionFactory getSessionFactory() {
			if(sessionFactory == null) {
				try {
					Configuration cfg = new Configuration();
					Properties settings = new Properties();
					settings.put(Environment.DRIVER, "org.postgresql.Driver");
					settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/data");
					settings.put(Environment.USER, "postgres");
					settings.put(Environment.PASS, "sandy");
					settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL94Dialect");
					settings.put(Environment.SHOW_SQL, "true");
					settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
					settings.put(Environment.HBM2DDL_AUTO, "create");
					cfg.setProperties(settings);
					cfg.addAnnotatedClass(Book.class);
					cfg.addAnnotatedClass(Author.class);
					//establish service for the db
					ServiceRegistry serviceRegistry = 
							new StandardServiceRegistryBuilder()
							  .applySettings(cfg.getProperties()).build();
					
					sessionFactory = cfg.buildSessionFactory(serviceRegistry);
					return sessionFactory;
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			return sessionFactory;
		}

}


