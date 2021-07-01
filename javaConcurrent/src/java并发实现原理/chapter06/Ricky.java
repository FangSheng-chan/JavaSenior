package java并发实现原理.chapter06;

/**
 * @author fangsheng
 * @date 2021/6/29 3:32 下午
 */
public class Ricky implements Student{

    @Override
    public void resolveQuestion(Callback callback) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callback.tellAnswer(3);
    }
}
