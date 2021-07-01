package java并发实现原理.chapter01.锁;

/**
 * @author fangsheng
 * @date 2021/6/28 3:34 下午
 */
public class Lock2 {
    boolean isLocked = false;
    Thread lockedBy = null;
    int lockedCount = 0;


    public synchronized void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (isLocked && lockedBy != thread) {
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = thread;
    }

    public synchronized void unlock(){
        if(Thread.currentThread() == this.lockedBy){
            lockedCount--;
            if(lockedCount == 0){
                isLocked = false;
                notify();
            }
        }
    }
}
