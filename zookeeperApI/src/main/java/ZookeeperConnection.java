import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author fangsheng
 * @date 2021/4/11 下午8:01
 */
public class ZookeeperConnection {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        try {
            ZooKeeper zooKeeper = new ZooKeeper("121.5.253.240:2181", 5000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                        System.out.println("连接成功");
                        countDownLatch.countDown();
                    }
                }
            });
            countDownLatch.await();
            System.out.println(zooKeeper.getSessionId());
            zooKeeper.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
