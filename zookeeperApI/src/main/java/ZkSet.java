import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author fangsheng
 * @date 2021/4/11 下午10:34
 */
public class ZkSet {
    ZooKeeper zooKeeper;

    @Before
    public void before() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        zooKeeper = new ZooKeeper("121.5.253.240:2181", 5000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    System.out.println("连接成功");
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();
    }

    @After
    public void after() throws Exception {
        zooKeeper.close();
    }


    @Test
    public void set1() throws Exception{
        //节点路径
        //修改的数据
        //版本号 -1代表版本号不参与更新
        Stat stat = zooKeeper.setData("/set/node1", "node13".getBytes(), -1);
        int aversion = stat.getAversion();
        System.out.println(aversion);
    }

    @Test
    public void set2() throws Exception{
        zooKeeper.setData("/set/node1", "node14".getBytes(), -1,new AsyncCallback.StatCallback() {
            @Override
            public void processResult(int i, String s, Object o, Stat stat) {
                System.out.println("是否修改成功"+i);
                System.out.println("路径"+s);
                System.out.println("上下文参数对象"+o);
                System.out.println(stat.getAversion());
            }
        },"I am Context");
    }
}
