package 网络编程;

import org.junit.Test;

import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author fangsheng
 * @date 2021/3/18 下午7:58
 */
public class InetAddressTest {
    @Test
    public void test01() throws UnknownHostException {
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);

        InetAddress inet3 = InetAddress.getByName("127.0.0.1");
        System.out.println(inet3);

        //获取本地ip
        InetAddress inet4 = InetAddress.getLocalHost();
        System.out.println(inet4);
    }
}
