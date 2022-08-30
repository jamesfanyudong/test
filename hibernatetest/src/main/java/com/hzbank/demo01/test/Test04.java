package com.hzbank.demo01.test;


import com.hzbank.demo01.entity.Account;
import com.hzbank.demo01.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test04 {


    public static void main(String[] args) {
        // 创建configuration
        Configuration configure = new Configuration().configure();
        // 获取sessionfactiory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        // 获取session
        Session session = sessionFactory.openSession();
        Account account = session.get(Account.class, 3);
        System.out.println(account);
        session.beginTransaction().commit();
        session.close();


    }






}


