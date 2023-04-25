# ==javaweb==

#### XML简介

​	xml是可扩展标记性语言

#### XML的主要作用

 主要作用1.用来保存数据，而且这些数据具有自我描述性

2.它还可以作为项目或者模块的配置文件



### Servlet的生命周期

> ​		1.执行servlet构造器方法
>
> ​		2.执行init初始化方法     
>
>  第一步，第二部，实在第一次访问，的时候创建Servlet程序会调用
>
> ​		
>
> ​		3.执行service方法
>
> 第三步，每次访问都会调用



> ​		 4.执行destroy销毁方法



a.html不要放在WEB-ING当中





```xml
<servlet>
    <!-- 标签Servlet程序起一个别名-->
        <servlet-name>HelloServlet</servlet-name>
        <servlet-class>HelloServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
```



##### f)通过继承HttpServlet实现Servlet程序

> 一般在实际项目开发中， 都是使用继承HttpServlert类的方式去实现Servlet程序
>
> 1.编写一个类去继承HTTPsERLVERTT类
>
> 2.根据业务需要重写doGet或doPost方法
>
> 3.到web.xml中的配置Servlet程序的访问地址

### 2。ServletConfig类

servietconfig类从类名上来看，就知道是Servlet程序的配置信息



servlet程序和servletConfig对象 都是由Tomcat负责创建，我们负责使用

Servlet程序默认第一次访问的时候创建,ServletConfi是每个Servlet程序创建时，就创建一个对应的ServletConfig对象

##### a)ServletConfig类的三大作用

> 1.可以获取Servlet程序的别名servlet-name的值
>
> 2.获取初始化参数init-param
>
> 3.获取ServletContext对象

```java
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

```

