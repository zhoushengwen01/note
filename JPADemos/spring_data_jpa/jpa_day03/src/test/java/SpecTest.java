import com.glaway.dao.CustomerDao;
import com.glaway.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")//指定spring容器的配置信息
public class SpecTest {
    @Autowired
    CustomerDao customerDao;

    //按照条件查询一个
    @Test
    public void testFindOne() {
        Specification<Customer> customerSpecification = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
                Predicate p = criteriaBuilder.equal(custName, "王五");
                return p;
            }
        };
        Customer one = customerDao.findOne(customerSpecification);
        System.out.println(one);

    }

    //多条件查询
    @Test
    public void testManyCondition() {
        Specification<Customer> specification = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");
                Path<Object> custIndustry = root.get("custIndustry");
                Predicate pName = criteriaBuilder.equal(custName, "张三");
                Predicate pIndustry = criteriaBuilder.equal(custIndustry, "教育");
                Predicate and = criteriaBuilder.and(pName, pIndustry);
                return and;
            }
        };
        Customer one = customerDao.findOne(specification);
        System.out.println(one);

    }

    @Test
    public void testLike() {
        Specification<Customer> specification = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");

                Predicate p = criteriaBuilder.like(custName.as(String.class), "张%");
                return p;
            }
        };
        List<Customer> all = customerDao.findAll(specification);
        for (Customer customer : all) {
            System.out.println(customer);
        }

    }

    @Test
    public void testSort() {
        Specification<Customer> specification = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> custName = root.get("custName");

                Predicate p = criteriaBuilder.like(custName.as(String.class), "张%");
                return p;
            }
        };
        Sort custId = new Sort(Sort.Direction.DESC, "custId");
        List<Customer> all = customerDao.findAll(specification, custId);
        for (Customer customer : all) {
            System.out.println(customer);
        }

    }

    //分页查询
    @Test
    public void testPage() {
        Specification specification=null;
        Pageable pageable = new PageRequest(0,2);
        Page page = customerDao.findAll(specification, pageable);
        System.out.println("总条数:"+page.getTotalElements());
        System.out.println("总页数:"+page.getTotalPages());
        System.out.println("查询出的集合:"+page.getContent());
    }

    @Test
    public void testSpec() {

    }
}



