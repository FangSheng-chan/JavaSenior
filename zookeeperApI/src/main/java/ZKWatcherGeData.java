import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @author fangsheng
 * @date 2021/4/18 下午6:22
 */
public class ZKWatcherGeData {

    static CountDownLatch countDownLatch = new CountDownLatch(1);

    static ZooKeeper zooKeeper;

    public static void main(String[] args) {
//        new ZooKeeper("121.5.253.240",5000,new ZKWatcherGeData())
    }
}
