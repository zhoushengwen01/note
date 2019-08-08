import com.glaway.dao.CustomerDao;
import com.glaway.dao.LinkManDao;
import com.glaway.entity.Customer;
import com.glaway.entity.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional//配置事务
    @Rollback(false)//不自动回滚
    public void testAdd() {
        Customer customer = new Customer();
        customer.setCustName("谷歌");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小卢");

        //customer.getLinkManSet().add(linkMan);
        linkMan.setCustomer(customer);

        customerDao.save(customer);
        linkManDao.save(linkMan);
    }


    //级联添加 保存一个客户的同时保存客户的所有联系人

    @Test
    @Transactional//配置事务
    @Rollback(false)//不自动回滚
    public void testCascadeAdd() {
        Customer customer = new Customer();
        customer.setCustName("谷歌");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小卢");
        linkMan.setCustomer(customer);

        customerDao.save(customer);
        customer.getLinkManSet().add(linkMan);


    }

    //级联删除 删除一个客户的同时删除客户的所有联系人

    @Test
    @Transactional//配置事务
    @Rollback(false)//不自动回滚
    public void testCascadeDelete() {
        Customer one = customerDao.findOne(1L);
        customerDao.delete(one);
    }


}
