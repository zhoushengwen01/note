package com.glaway.dao;

import com.glaway.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sun.awt.SunHints;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer, Long>, JpaSpecificationExecutor<Customer> {

    @Query(value = "from Customer where custName= ?1")
    public Customer findJpql(String custName);

    @Query(value = "from  Customer where custName=?1 and id=?2")
    public Customer findByNameAndCustId(String name, Long id);

    @Query(value = "update Customer set custName=?2 where custId=?1 ")
    @Modifying   //代表更新操作
    public void updateNameById(Long id, String name);


    //nataiveQuery:是否使用sql查询(true : sql,false : jpql)
    @Query(value = "select * from cst_customer",nativeQuery = true)
    public List<Object[]> findSql();



    //方法名称规则查询

    public List<Customer> findByCustName(String name);

    //模糊查询
    public List<Customer> findByCustNameLike(String name);

    //模糊查询加条件
    public List<Customer> findByCustNameLikeAndCustIndustry(String name,String industry);

}
