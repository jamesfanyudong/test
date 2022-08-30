package com.hzbank.demo01.test;

import com.hzbank.demo01.entity.Customer;
import com.hzbank.demo01.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test02 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new
                Configuration().configure();
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();
        //创建 Customer
        Customer customer = session.get(Customer.class, 1);
        System.out.println(customer.getOrders().size());

        //提交事务
        session.beginTransaction().commit();
        //关闭session
        session.close();
    }
}
