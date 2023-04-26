# ==javaweb==

### XML简介

​	xml是可扩展标记性语言

#### XML的主要作用

 主要作用1.用来保存数据，而且这些数据具有自我描述性

2.它还可以作为项目或者模块的配置文件



### Servlet的生命周期

> ​		1.执行servlet构造器方法
>
> ​		2.执行init初始化方法     
>
> ​		
>
> ```
> init( ),当Servlet第一次被请求时，Servlet容器就会开始调用这个方法来初始化一个Servlet对象出来，但是这个方法在后续请求中不会在被Servlet容器调		用，就像人只能“出生”一次一样。我们可以利用init（ ）方法来执行相应的初始化工作。调用这个方法时，Servlet容器会传入一个ServletConfig对象进来		从而对Servlet对象进行初始化。
> 
> ```
>
> 第一步，第二部，实在第一次访问，的时候创建Servlet程序会调用
>
> ​		
>
> ​		3.执行service方法
>
> ```
> 	每当请求Servlet时，Servlet容器就会调用这个方法。就像人一样，需要不停的接受老板的指令并且“工作”。第一次请求时，Servlet容器会先调用init( )方法初始化一个Servlet对象出来，然后会调用它的service( )方法进行工作，但在后续的请求中，Servlet容器只会调用service方法了
> ```
> 
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



##### HttpServlet抽象类

HttpServlet抽象类是继承于GenericServlet抽象类而来的，使用HttpServlet抽象类时，还需要借助分别代表Servlet请求和Servlet响应的HttpServlertRequest和HttpServletResponse对象

##### 2.ServletConfig接口

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

### 3.ServletContext对象

ServletContext对象表示Servlet应用程序，在将一个应用程序同时部署到多个容器的分布式环境中，每台Java虚拟机上的Web应用都会有一个ServletContext对象

> 那么为什么要存在一个ServletContext对象呢？存在肯定是有它的道理，因为有了ServletContext对象，就可以共享从应用程序中的所有资料处访问到的信息，并且可以动态注册Web对象。前者将对象保存在ServletContext中的一个内部Map中。保存在ServletContext中的对象被称作属性。
> 

**1.ServletContext是一个接口，它表示Servlet上下文对象**

**2==.一个Web工程，只有一个ServletContext对象实例==**

**3.ServletContext对象是一个域 对象**

​    

|        | 存数据          | 取数据         | 删除数据           |
| :----: | --------------- | -------------- | ------------------ |
|  Map   | put()           | get()          | remove()           |
| 域对象 | setAttributew() | getAttribute() | removeAttribute(); |





什么是域对象？

​		域对象，是可以像Map一样存取数据的对象，叫域对象

​		这里的域指的是存取数据的操作范围



##### b)ServletContext类的四个作用

> 1.获取web.xml 中配置的上下文参数context-parm
>
> 2.获取当前工程路径,格式:/工程路径
>
> 3.获取工程部署后在服务器硬盘上的绝对路径
>
> 4.像map一样存储数据

1

```xml
<!--   
如果有一段配置信息希望多个servlet都可以使用，可以为多个servlet都配置相关信息，这个操作会造成代码冗余。可以把这段配置信息抽取成一个全局配置这样所有的servlet都可以获取这个信息

    全局配置信息（web.xml文件中来进行配置）-->


<context-param>
        <param-name>username</param-name>
        <param-value>context</param-value>
    </context-param>
//键值对

    <context-param>
        <param-name>password</param-name>
        <param-value>root</param-value>
    </context-param>
```

```java
ServletContext servletContext = getServletConfig().getServletContext();


        servletContext.getInitParameter("drive");
        String username = servletContext.getInitParameter("username");
```

==4.像map一样存储数据==

```java
ServletContext context = getServletContext();
        context.setAttribute("key1","value1");

        System.out.println("context1获取数据key1的值是+"+context.getAttribute("key1"));
//更换另一个context类仍然可以获取到Key1
```



### Http协议

​	什么是协议？

​		协议是指双方，或多方，相互约定好，大家都需要遵守的规则，叫协议

所谓HTTP协议就是指，客户端和服务器之间通信时，发送的数据，需要遵守的规则，叫HTTP协议

Http协议中的数据又叫报文

##### b)请求的HTTP协议格式

​	1.GET请求

​			1.请求行

​					(1)请求的方式					GET	

​					(2)请求的资源路径[+?+请求参数]

​				    (3)请求的协议版本号        HTTP/1.1

2.请求头

![](C:\Users\Administrator\Desktop\MYsql\web.PNG)

2.POST	

 1、请求行

​			         (1)请求的方式					GET	

​					(2)请求的资源路径[+?+请求参数]

​				    (3)请求的协议版本号        HTTP/1.1

   2、  请求头

​				1)key :value     不同的请求头，有不同的含义

​				==空行==

​     请求体





1. 常用请求头的说明

> Accept:表示客户端可以接受的数据类型
>
> Accept-Languege：表示客户端可以接受的语言类型
>
> User-Agent:表示客户端浏览
>
> Host:表示请求时的服务器ip和端口号

- 那些是GET请求，哪些是POST请求

  <u>GET请求有哪些</u>

  > 1.from标签 method=get
  >
  > 2.a标签
  >
  > 3.link标签引入css
  >
  > 4.Script标签引入Js文件
  >
  > 5.img标签引入图片
  >
  > 6.iframe引入html
  >
  > 7.在浏览器地址栏中输入地址敲回车

POST请求有哪些？

> 8、form标签 method=post

##### c)响应的HTTP协议格式

1.响应行

​			(1)响应的协议和版本号      HTTP/1.1

​			(2)响应状态码                        200

​			(3)响应状态描述符                    ok

 2.响应头

​	（1）key :value 不同的响应头，有其不同含义

​		==空行==

3.响应体----->>>   就是回传给客户端的数据