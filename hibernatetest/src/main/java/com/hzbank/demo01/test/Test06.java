package com.hzbank.demo01.test;


import com.hzbank.demo01.entity.Customer;
import com.hzbank.demo01.entity.People;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test06 {


    public static void main(String[] args) {
        // 创建configuration
        Configuration configure = new Configuration().configure();
        // 获取sessionfactiory
        SessionFactory sessionFactory = configure.buildSessionFactory();
        // 获取session
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class, 456);
        session.delete(customer);


        session.beginTransaction().commit();
        session.close();


    }






}


