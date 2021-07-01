package java并发实现原理.chapter06;

import org.junit.Test;

/**
 * @author fangsheng
 * @date 2021/6/29 3:33 下午
 */
public class CallbackTest {
    @Test
    public void testCallback() {
        Student student = new Ricky();
        Teacher teacher = new Teacher(student);
        teacher.askQuestion();
    }
}
