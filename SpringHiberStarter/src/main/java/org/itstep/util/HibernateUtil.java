package org.itstep.util;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		String sep = System.getProperty("file.separator");
		try {
			System.out.println(System.getProperty("base.dir"));
			return new AnnotationConfiguration()
					.configure(new File("C:"+sep+"Users"+sep+"Lesha"+sep+"git"+sep+"SpringHiberStarter"+sep+"SpringHiberStarter"+sep+"src"+sep+"main"+sep+"java"+sep+"org"+sep+"itstep"+sep+"config"+sep+"hibernate.cgf.xml"))
					.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}
}
