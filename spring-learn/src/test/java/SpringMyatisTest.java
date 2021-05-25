import com.ss.model.Boy;
import com.ss.service.BoyService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author fangsheng
 * @date 2021/5/24 2:06 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml", "classpath:applicationContext.xml"})
public class SpringMyatisTest {

    private static final String[] CONFIG_LOCATIONS = {"spring-mybatis.xml", "applicationContext.xml"};

    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONFIG_LOCATIONS);

    @Resource
    private BoyService boyService;


    @Test
    public void t1() {
        /* 得到 SqlSession 对象*/
        SqlSession sqlSession = (SqlSession) context.getBean("sqlSession");
        int id = 2;
        Boy boy = sqlSession.selectOne("com.ss.mapper.BoyMapper.getBoyById", id);
        System.out.println(boy);
    }

    @Test
    public void t2() {
        boyService.delBoy();
    }
}
