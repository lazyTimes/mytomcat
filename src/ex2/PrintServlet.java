package ex2;

import javax.servlet.*;
import java.io.IOException;

/**
 * @program: mytomcat
 * @description: 打印servlet
 * @author: zhaoxudong
 * @create: 2020-05-31 11:31
 **/
public class PrintServlet implements Servlet {


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
