package com.hzbank.demo01.test;


import com.hzbank.demo01.entity.Customer;
import com.hzbank.demo01.entity.Orders;
import com.hzbank.demo01.entity.People;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class Test07 {


        // 创建configuration
       static Configuration configure = new Configuration().configure();
        // 获取sessionfactiory
       static SessionFactory sessionFactory = configure.buildSessionFactory();
        // 获取session
       static Session session = sessionFactory.openSession();


    public static void main(String[] args) {

        Customer customer = session.get(Customer.class, 456);
        session.delete(customer);

    }


    @Test
    public void testPage(){
        try {
            String hql = "from " + People.class.getName();
            Query query = session.createQuery(hql);

            query.setFirstResult(1);
            query.setMaxResults(3);
            query.list().forEach(System.out::println);
        }finally {
            session.beginTransaction().commit();
            session.close();
        }
    }

    @Test
    public void testLike(){
        try {
            String hql = "from " + People.class.getName() + " where name like '%大%' ";
            Query query = session.createQuery(hql);

            query.setFirstResult(0);
            query.setMaxResults(3);
            query.list().forEach(System.out::println);
        }finally {
            session.beginTransaction().commit();
            session.close();
        }
    }

    @Test
    public void testOrderBy(){
        try {
            String hql = "from " + People.class.getName() + " order by id asc";
            Query query = session.createQuery(hql);

            query.setFirstResult(0);
            query.setMaxResults(3);
            query.list().forEach(System.out::println);
        }finally {
            session.beginTransaction().commit();
            session.close();
        }
    }

    @Test
    public void testProperty(){
        try {
            String hql = "select name from " + People.class.getName() + " where id = 1";
            Query query = session.createQuery(hql);


            query.setFirstResult(0);
            query.setMaxResults(3);
            query.list().forEach(System.out::println);
        }finally {
            session.beginTransaction().commit();
            session.close();
        }
    }

    @Test
    public void testZhanweifu(){
        try {
            String hql = "from " + People.class.getName() + " where name = :name";
            Query query = session.createQuery(hql);
            query.setString("name","12323大萨达");

            Object name = query.uniqueResult();
            System.out.println("name = " + name);
        }finally {
            session.beginTransaction().commit();
            session.close();
        }
    }

    @Test
    public void testCasdcade(){
        try {
            String hql1 = "from " + Customer.class.getName() + " where name = :name";
            Query query1 = session.createQuery(hql1);
            query1.setString("name","zhangsan");

            Customer customer = (Customer)query1.uniqueResult();
            String hql2 = "from " + Orders.class.getName() + " where customer = :customer";
            Query query2 = session.createQuery(hql2);
            query2.setEntity("customer",customer);
            query2.list().forEach(System.out::println);


        }finally {
            session.beginTransaction().commit();
            session.close();
        }
    }



}






