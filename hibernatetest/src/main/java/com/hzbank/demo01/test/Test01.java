package com.hzbank.demo01.test;


import com.hzbank.demo01.entity.People;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test01 {


    public static void main(String[] args) {
        // 创建configuration
        Configuration configure = new Configuration().configure();
        // 获取sessionfactiory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        // 获取session
        Session session = sessionFactory.openSession();
        People people = new People();
        people.setName("jskfjak");
        people.setMoney(100.0);
        session.save(people);
        session.beginTransaction().commit();
        session.close();


    }






}


