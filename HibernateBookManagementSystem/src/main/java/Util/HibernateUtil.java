package Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration cfg = new Configuration().configure("hiber.config.xml");
            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("connection established"+ ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
