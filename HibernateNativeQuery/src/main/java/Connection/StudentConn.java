package Connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentConn {
    private static SessionFactory sf;

    static {
        Configuration cfg = new Configuration().configure("hiber.config.xml");
        sf = cfg.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sf;
    }
}

