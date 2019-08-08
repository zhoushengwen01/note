import com.glaway.dao.CustomerDao;
import com.glaway.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class JpqlTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindByName(){
        Customer customer = customerDao.findJpql("张三");
        System.out.println(customer);
    }

    @Test
    public void testFindBynameAndId(){
        Customer customer = customerDao.findByNameAndCustId("张三",3L);
        System.out.println(customer);
    }


    @Test
    @Transactional //添加事务
    @Rollback(value = false)//是否回滚
    public void testUpdate(){
        customerDao.updateNameById(2L,"王五");
    }


    @Test
    public void testSql(){
        List<Object[]> customers = customerDao.findSql();
        for (Object[] customer : customers) {
            System.out.println(Arrays.toString(customer));
        }

    }


    @Test
    public void testByName(){
        List<Customer> customers = customerDao.findByCustName("张三");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }


    @Test
    public void testFindLike(){
        List<Customer> customers = customerDao.findByCustNameLike("张%");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void testLikeAnd(){
        List<Customer> customers = customerDao.findByCustNameLikeAndCustIndustry("张%", "搬砖");
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }

    }






}
