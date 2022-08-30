package com.hzbank.demo01.test;

import com.hzbank.demo01.entity.Account;
import com.hzbank.demo01.entity.Course;
import com.hzbank.demo01.entity.Customer;
import com.hzbank.demo01.entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.HashSet;

public class Test03 {
    public static void main(String[] args) {
        //创建 Configuration
        Configuration configuration = new
                Configuration().configure();
        //获取 SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        //获取 Session
        Session session = sessionFactory.openSession();
        //创建 Course
        Course course1 = new Course();
        Course course2 = new Course();
        course1.setName("java12121");
        course2.setName("php121212");

        // 创建 Account
        Account account1 = new Account();
        Account account2 = new Account();
        account1.setName("张三11");
        account2.setName("李四11");


        HashSet<Course> set1 = new HashSet<>();
        HashSet<Course> set2 = new HashSet<>();
        set2.add(course1);
        set1.add(course1);
        set1.add(course2);

        account1.setCourses(set1);

        session.save(course1);
        session.save(course2);
        session.save(account1);
        session.save(account2);

        //保存

        //提交事务
        session.beginTransaction().commit();
        //关闭session
        session.close();
    }
}
