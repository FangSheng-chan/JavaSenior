package java并发实现原理.chapter01.锁;

/**
 * @author fangsheng
 * @date 2021/6/23 12:26 下午
 */
public class ObjectService {

    public void serviceMethodA() {
        try {
            synchronized (this) {
                System.out.println("A begin time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end   time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodB() {
        synchronized (this) {
            System.out.println("B begin time=" + System.currentTimeMillis());
            System.out.println("B end   time=" + System.currentTimeMillis());
        }
    }

    public void serviceMethodD() {
        synchronized (this) {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println("synchronized thread name:" + Thread.currentThread().getName() + "-->i=" + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public synchronized void serviceMethodC() {
        System.out.println("run serviceMethodC");
    }

    private String uname;
    private String pwd;
    String lock = new String();

    public void setUserNamePassword(String userName, String password) {
        try {
            synchronized (lock) {
                System.out.println("thread name=" + Thread.currentThread().getName()
                        + " 进入代码快:" + System.currentTimeMillis());
                uname = userName;
                Thread.sleep(3000);
                pwd = password;
                System.out.println("thread name=" + Thread.currentThread().getName()
                        + " 进入代码快:" + System.currentTimeMillis() + "入参uname:" + uname + "入参pwd:" + pwd);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodE() {
        try {
            synchronized (lock) {
                System.out.println("a begin");
                Thread.sleep(3000);
                System.out.println("a   end");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void serviceMethodF() {
        System.out.println("b begin");
        System.out.println("b   end");
    }

    public synchronized static void serviceMethodG() {
        try {
            System.out.println("static methodA begin 线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("static methodA end   线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void serviceMethodH() {
        System.out.println("static methodB begin 线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
        System.out.println("static methodB end   线程名称:" + Thread.currentThread().getName() + " times:" + System.currentTimeMillis());
    }

    public void serviceMethodI(){
        try {
            synchronized (ObjectService.class) {
                System.out.println("methodA begin 线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
                Thread.sleep(3000);
                System.out.println("methodA end   线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void serviceMethodJ(){
        synchronized (ObjectService.class) {
            System.out.println("methodB begin 线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
            System.out.println("methodB end   线程名称:"+Thread.currentThread().getName()+" times:"+System.currentTimeMillis());
        }
    }



}
