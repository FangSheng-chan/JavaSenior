package nio1;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @author fangsheng
 * @date 2021/5/18 9:50 上午
 */
public class T1 {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("www.baidu.com", 908);
        System.out.println(socketAddress.getAddress());
    }
}
