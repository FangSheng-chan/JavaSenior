package java并发编程之美.chapter1;

import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author fangsheng
 * @date 2021/5/29 3:55 下午
 */
public class T1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        try {
            // offer方法，当队列满了就会丢弃要入队的元素，之后offer方法会返回false,而不会阻塞队当前线程
            blockingQueue.offer("s", 3, TimeUnit.SECONDS);
            // put方法，当队列满了，则会挂起当前线程，直到队列有空闲，元素入队成功后才返回
            blockingQueue.put("s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }







    @Test
    public void t1() {
        final String[] strings = {"1", "2", null};
        strings[2] = "3";
        System.out.println(Arrays.toString(strings));
        String s = "133";
    }

    @Test
    public void t2() {
        final FinalString fs = new FinalString("1");
        fs.setStr("2");
        System.out.println(fs.getStr());
    }

    @Test
    public void t3(){
        final FinalString finalString1 = new FinalString("1");
        final FinalString finalString2 = new FinalString("2");
//        finalString1 = finalString2;
        System.out.println(finalString1);
        final String[] strs0 = {"123","234"};
        final String[] strs1 = {"345","456"};
//        strs1 = strs0;
        strs1[1] = "333";

    }

    private void A(final FinalString fs)
    {
        fs.setStr("123");
        FinalString fss = new FinalString("22");
//        fs = fss;
    }

    public class FinalString {
        private String str;

        public FinalString(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        @Override
        public String toString() {
            return "FinalString{" +
                    "str='" + str + '\'' +
                    '}';
        }
    }
}
