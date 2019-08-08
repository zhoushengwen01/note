import com.glaway.dao.RoleDao;
import com.glaway.dao.UserDao;
import com.glaway.entity.Role;
import com.glaway.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.NamingEnumeration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyToManyTest {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("小卢");
        Role role = new Role();
        role.setRoleName("程序员");

        role.getUsers().add(user);
        user.getRoles().add(role);



        userDao.save(user);
        roleDao.save(role);
    }



    //级联添加
    @Test
    public void testCadeAdd(){

        User user = new User();
        user.setUserName("老王");
        Role role = new Role();
        role.setRoleName("网瘾少年");

        user.getRoles().add(role);

        userDao.save(user);
    }

    //级联删除
    @Test
    public void testCadeRomove(){

        User one = userDao.findOne(4L);
        userDao.delete(one);


    }


}
