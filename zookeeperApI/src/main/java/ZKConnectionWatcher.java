import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.jar.JarOutputStream;

/**
 * @author fangsheng
 * @date 2021/4/18 下午8:08
 */
public class ZKConnectionWatcher implements Watcher {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    static ZooKeeper zooKeeper;

    public static void main(String[] args) {
        try {
            zooKeeper = new ZooKeeper("121.5.253.240", 5000, new ZKConnectionWatcher());
            //阻塞线程
            countDownLatch.await();
            long sessionId = zooKeeper.getSessionId();
            System.out.println(sessionId);
            Thread.sleep(3000);
            zooKeeper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            if (watchedEvent.getType() == Event.EventType.None) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected){
                    System.out.println("连接创建成功");
                    countDownLatch.countDown();
                }else if(watchedEvent.getState() == Event.KeeperState.Disconnected){
                    System.out.println("断开连接");
                }else if (watchedEvent.getState() == Event.KeeperState.Expired){
                    System.out.println("回话超时");
                }else if (watchedEvent.getState() == Event.KeeperState.AuthFailed){
                    System.out.println("认证失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
}
