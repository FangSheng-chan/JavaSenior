package threadDemo;

import java.time.LocalTime;

/**
 * @author fangsheng
 * @date 2021/2/24 下午3:29
 */
public class Thread06 {
    public static void main(String[] args) {
        TimerThread timerThread = new TimerThread();
        timerThread.setDaemon(true);
        timerThread.start();
    }

    static class TimerThread extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println(LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
