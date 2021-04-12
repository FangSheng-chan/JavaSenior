package t1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet 生命周期可被定义为从创建直到毁灭的整个过程。以下是 Servlet 遵循的过程：
 *
 * Servlet 初始化后调用 init () 方法。
 * Servlet 调用 service() 方法来处理客户端的请求。
 * Servlet 销毁前调用 destroy() 方法。
 * 最后，Servlet 是由 JVM 的垃圾回收器进行垃圾回收的。
 */

/**
 * @author fangsheng
 * @date 2021/4/7 下午3:15
 */
public class T2 extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
