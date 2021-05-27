package Io通信;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author fangsheng
 * @date 2021/5/26 6:38 下午
 */
public class IOClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    Socket socket = new Socket("127.0.0.1", 8000);
                    while (true) {
                        try {
                            socket.getOutputStream().write((new Date() + ": hello world" + Thread.currentThread().getName()).getBytes());
                            Thread.sleep(2000);
                        } catch (Exception e) {
                        }
                    }
                } catch (IOException e) {
                }
            }, String.valueOf(i)).start();
        }
    }
}
