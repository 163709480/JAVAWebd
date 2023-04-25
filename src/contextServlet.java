
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class contextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {





//        1.获取web.xml 中配置的上下文参数context-parm
        ServletContext servletContext = getServletConfig().getServletContext();


        servletContext.getInitParameter("drive");
        String username = servletContext.getInitParameter("username");
        System.out.println("context -param参数username的值是"+username);
        System.out.println("context -param参数password的值是"+servletContext.getInitParameter("password"));
//        2.获取当前工程路径,格式:/工程路径
        System.out.println("当前工程路径为"+servletContext.getContextPath());


//        3.获取工程部署后在服务器硬盘上的绝对路径
        //映射到idea代码的web目录

        System.out.println("工程部署的路径是"+servletContext.getRealPath("/"));
        System.out.println("工程luj"+servletContext.getRealPath("/css"));


        System.out.println( servletContext.getAttribute("key1"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {






    }
}
