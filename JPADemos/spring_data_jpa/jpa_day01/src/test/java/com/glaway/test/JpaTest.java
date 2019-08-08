package com.glaway.test;

import com.glaway.domain.Customer;
import com.glaway.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    //增
    @Test
    public void testSave() {
       // EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
      //  EntityManager em = factory.createEntityManager();

        EntityManager em = JpaUtils.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Customer customer = new Customer();
        customer.setCustName("李四");
        customer.setCustIndustry("程序员");

        em.persist(customer);//保存
        et.commit();

        em.close();
       // factory.close();

    }


    @Test
    /**
     * 立即加载
     */
    public void testFind(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.find(Customer.class, 1L);
        System.out.println(customer);
        transaction.commit();
        entityManager.close();
    }

    @Test
    /**
     * 延迟查询(懒加载)
     * 得到的是动态代理对象
     */
    public void testGetReference(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Customer customer = entityManager.getReference(Customer.class, 1L);
        System.out.println(customer);
        transaction.commit();
        entityManager.close();
    }

    @Test
    public void testRemove(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.getReference(Customer.class,1L);
        entityManager.remove(customer);

        transaction.commit();
        entityManager.close();
    }


    @Test
    public void testUpdate(){
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.getReference(Customer.class,2L);
       customer.setCustIndustry("教育");
       entityManager.merge(customer);

        transaction.commit();
        entityManager.close();
    }


}
