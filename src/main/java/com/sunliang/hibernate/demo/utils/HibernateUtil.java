package com.sunliang.hibernate.demo.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author sunliang
 * @desc hibernate工具类
 * @create 2017-12-12 10:29
 **/
public class HibernateUtil {

    private static SessionFactory factory;

    static {
        try {
            //读取hibernate.cfg.xml文件
            Configuration cfg = new Configuration().configure();

            //建立SessionFactory
            factory = cfg.buildSessionFactory();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static Session getSession() {
        return factory.openSession();
    }

    public static void closeSession(Session session) {
        if (session != null) {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
