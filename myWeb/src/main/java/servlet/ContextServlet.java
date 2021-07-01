package servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author fangsheng
 * @date 2021/6/22 12:22 下午
 */
public class ContextServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        /**
         * 获取初始参数
         */
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        System.out.println(username);
        System.out.println(password);
        /**
         * 获取当前工作路径
         */
        System.out.println(context.getContextPath());
        System.out.println("工程部署的路径是：" + context.getRealPath("/"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
