package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author fangsheng
 * @date 2021/7/5 12:39 下午
 */
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        System.out.println(user);
        if (user == null) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
