
import com.ss.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author fangsheng
 * @date 2021/5/21 11:13 上午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IOCTestAop {

    @Autowired
    private CustomerService customerService;

    @Test
    public void t1() {
        customerService.addCustomer(1L, "ss", "杭州");
    }
}
