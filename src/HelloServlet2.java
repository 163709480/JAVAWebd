import javax.servlet.*;
import java.io.IOException;

public class HelloServlet2 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2 init初始化方法");

         // 1.可以获取Servlet程序的别名servlet-name的值
        System.out.println("HelloSERVLET程序的别名是"+servletConfig.getServletName());
          //2.获取初始化参数init-param

        System.out.println("初始化参数username的值是"+servletConfig.getInitParameter("username"));
        System.out.println("初始化参数url的值是"+servletConfig.getInitParameter("url"));
         // 3.获取ServletContext对象
        System.out.println(servletConfig.getServletContext());




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
