import com.glaway.dao.CustomerDao;
import com.glaway.dao.LinkManDao;
import com.glaway.entity.Customer;
import com.glaway.entity.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ObjectQueryTest {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;

    @Test
    @Transactional
    public void testQuery1(){
        Customer customer = customerDao.getOne(2L);
        Set<LinkMan> linkManSet = customer.getLinkManSet();
        for (LinkMan linkMan : linkManSet) {
            System.out.println(linkMan);
        }
    }


    @Test
    @Transactional
    public void testQuery2(){
        Customer customer = customerDao.getOne(2L);
        Set<LinkMan> linkManSet = customer.getLinkManSet();
        for (LinkMan linkMan : linkManSet) {
            System.out.println(linkMan);
        }
    }
}
