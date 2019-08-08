package com.glaway.test;

import com.glaway.domain.Customer;
import com.glaway.utils.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

/**
 * 测试jpql查询
 */
public class JpqlTest {
    /**
     * &#x67e5;&#x8be2;&#x5168;&#x90e8;
     */
    @Test
    public void testFindAll() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql = "from Customer";
        Query query = entityManager.createQuery(jpql);
        List resultList = query.getResultList();
        for (Object customer : resultList) {
            System.out.println(customer);
        }


        transaction.commit();
        entityManager.close();
    }

    /**
     * 倒叙查询
     */
    @Test
    public void testOrder() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql = "from Customer order by custId desc";
        Query query = entityManager.createQuery(jpql);
        List resultList = query.getResultList();
        for (Object customer : resultList) {
            System.out.println(customer);
        }


        transaction.commit();
        entityManager.close();
    }

    /**
     * 查询个数
     */
    @Test
    public void testCount() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql = "select count (custId) from  Customer";
        Query query = entityManager.createQuery(jpql);
        Long number = (Long) query.getSingleResult();
        System.out.println(number);
        transaction.commit();
        entityManager.close();
    }

    /**
     * 分页查询
     */
    @Test
    public void testPaged() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql = "from  Customer";
        Query query = entityManager.createQuery(jpql);
        query.setFirstResult(0);
        query.setMaxResults(2);
        List<Customer> resultList = query.getResultList();
        for (Customer o : resultList) {
            System.out.println(o);
        }
        transaction.commit();
        entityManager.close();
    }

    /**
     * 条件查询
     */
    @Test
    public void testCondition() {
        EntityManager entityManager = JpaUtils.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        String jpql = "from  Customer where custName like ?";
        Query query = entityManager.createQuery(jpql);
        query.setParameter(1, "张%");
        List<Customer> resultList = query.getResultList();
        for (Customer o : resultList) {
            System.out.println(o);
        }
        transaction.commit();
        entityManager.close();
    }


}
