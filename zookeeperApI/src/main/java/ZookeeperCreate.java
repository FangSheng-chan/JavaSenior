import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * @author fangsheng
 * @date 2021/4/11 下午8:24
 */
public class ZookeeperCreate {

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
    public void test1() throws Exception {
        zooKeeper.create("/ss", "ss123".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
    }

    @Test
    public void create2() throws Exception {
        ArrayList<ACL> acls = new ArrayList<>();
        Id id = new Id("world", "anyone");
        acls.add(new ACL(ZooDefs.Perms.READ, id));
        acls.add(new ACL(ZooDefs.Perms.WRITE, id));
        zooKeeper.create("/ss/node1", "ssNode1".getBytes(), acls, CreateMode.PERSISTENT);
    }

    @Test
    public void create3() throws Exception {
        zooKeeper.addAuthInfo("digest", "ss:123456".getBytes());
        zooKeeper.create("/ss/node5", "ssNode5".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
    }

    @Test
    public void create() throws Exception {
        //auth 授权模式
        //添加授权用户
        zooKeeper.addAuthInfo("digest", "ss:Hello.001".getBytes());
        ArrayList<ACL> acls = new ArrayList<>();
        Id id = new Id("auth", "ss");
        acls.add(new ACL(ZooDefs.Perms.READ, id));
        zooKeeper.create("/ss/node6", "ssNode6".getBytes(), acls, CreateMode.PERSISTENT);
    }
}
