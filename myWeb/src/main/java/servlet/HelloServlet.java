package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ss
 */
public class HelloServlet implements Servlet {

    public HelloServlet() {
        System.out.println("1 构造器方法");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("2 init方法");
        System.out.println("helloServlet程序的别名\t"+config.getServletName());
        System.out.println("初始化参数username的值\t"+config.getInitParameter("username"));
        System.out.println(config.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String method = httpServletRequest.getMethod();
        System.out.println(method);
        System.out.println("3 service hello servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4 destroy方法");
    }


}
