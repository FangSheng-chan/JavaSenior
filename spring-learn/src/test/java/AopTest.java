import com.ss.service.CustomerService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author fangsheng
 * @date 2021/5/21 2:11 下午
 */
public class AopTest {
    @Test
    public void t1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService customerService = context.getBean(CustomerService.class);
        customerService.addCustomer(1L, "ss", "杭州");
        customerService.addCustomer(1L, "ss", null);
    }
}
