import javax.servlet.*;
import java.io.IOException;

public class HelloServlet3 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 初始化默认init执行");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3  Servlet执行");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    public HelloServlet3() {
        System.out.println("1,HelloSevle构造器方法");
    }

    @Override
    public void destroy() {

        System.out.println("4 ,程序终止执行");
    }
}
