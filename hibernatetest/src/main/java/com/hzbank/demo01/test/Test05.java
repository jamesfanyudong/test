package com.hzbank.demo01.test;


import com.hzbank.demo01.entity.Account;
import com.hzbank.demo01.entity.People;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test05 {


    public static void main(String[] args) {
        // 创建configuration
        Configuration configure = new Configuration().configure();
        // 获取sessionfactiory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        // 获取session
        Session session = sessionFactory.openSession();
        String hql = "from " + People.class.getName() + " p where p.id = 1";
        Query query = session.createQuery(hql);
        query.list().forEach(System.out::println);



        session.beginTransaction().commit();
        session.close();


    }






}


