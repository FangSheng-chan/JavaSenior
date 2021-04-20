import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author fangsheng
 * @date 2021/4/18 下午6:22
 */
public class ZKWatcherGeData {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    static String IP = "121.5.253.240";
    ZooKeeper zooKeeper = null;

    @Before
    public void before() throws Exception {
        zooKeeper = new ZooKeeper(IP, 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("连接对象的参数");
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    countDownLatch.countDown();
                }
                System.out.println("path= " + watchedEvent.getPath());
                System.out.println("eventType= " + watchedEvent.getType());
            }
        });
        countDownLatch.await();
    }

    @After
    public void after() throws InterruptedException {
        zooKeeper.close();
    }


    @Test
    public void watcherGetData1() throws Exception {
        zooKeeper.getData("/watcher2", true, null);
        Thread.sleep(50000);
        System.out.println("结束");
    }

    @Test
    public void watcherGetData2() throws Exception {
        zooKeeper.getData("/watcher2", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("自定义watcher");
                System.out.println("path=" + watchedEvent.getPath());
                System.out.println("eventType=" + watchedEvent.getType());
                if (watchedEvent.getType() == Event.EventType.NodeDataChanged) {
                    try {
                        zooKeeper.getData("/watcher2", true, null);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, null);
        zooKeeper.getData("/watcher2", true, null);
        Thread.sleep(50000);
        System.out.println("结束");
    }

    public static void main(String[] args) {
//        new ZooKeeper("121.5.253.240",5000,new ZKWatcherGeData())
    }
}
