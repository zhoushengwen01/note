import com.glaway.dao.CustomerDao;
import com.glaway.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class CustomerDaoTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindOne(){
        Customer customer=customerDao.findOne(2l);
        System.out.println(customer.toString());
    }

    @Test
    public void testSave(){
        Customer customer=new Customer();
        customer.setCustIndustry("程序员");
        customer.setCustLevel("vip");
        customer.setCustName("赵六");
        customerDao.save(customer);
    }


    @Test
    public void testDelete(){
        customerDao.delete(3l);
    }

    @Test
    public void testFindAll(){
        List<Customer> customers = customerDao.findAll();
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    @Test
    public void testCount(){
        long count = customerDao.count();
        System.out.println(count);
    }

    @Test
    public void testExisit(){
        boolean exists = customerDao.exists(1L);
        System.out.println(exists);
    }

    //和findOne的区别是此方法为延迟加载
    @Test
    @Transactional
    public void testGetOne(){
        Customer customer = customerDao.getOne(2L);
        System.out.println(customer.toString());
    }


}
