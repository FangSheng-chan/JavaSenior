package 网络编程;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author fangsheng
 * @date 2021/3/19 下午3:39
 */
public class TCPTest {
    public static void main(String[] args) {

    }

    @Test
    public void client() {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.20.44");
            socket = new Socket(inetAddress, 8899);
            outputStream = socket.getOutputStream();
            outputStream.write("hello，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;

        try {
            serverSocket = new ServerSocket(8899);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            System.out.println(byteArrayOutputStream.toString());
            System.out.println("收到来自于：" + socket.getInetAddress().getHostAddress() + "的信息");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (byteArrayOutputStream != null) {
                //5.关闭资源
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
