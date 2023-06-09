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

![

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







### HttpServletRequest类

每次只要有请求进入Tomcat服务器，Tomcat服务器就会把请求过来的HTTP协议信息解析好封装到Requkest对象中。然后传递到service方法(doGet和doPost)中给我们使用，我们可以通过HttpServletRequest对象，获取到所有请求的信息



> i   getReaquestURI()    获取请求的资源路径
>
> i  getRequestURL()      获取请求的统一资源定位符(绝对路径)
>
> iii.    getRemoteHost()   获取客户端的ip地址
>
> getHeader()           	获取请求头
>
> getParameter()					获取请求的参数
>
> getParameterValues() 	 获取请求的参数(多个值的时候使用)
>
> getMethod()   					获取请求方式GET或POST
>
> setAttribute(key,value)     设置域数据
>
> getRequestDispatcher()    获取请求转发对象



```java
// i.getRequestURI()     获取请求的资源路径
        System.out.println("URI=>+"+req.getRequestURI());
        // i.getRequestURL()      获取请求的统一资源定位符(绝对路径)
        System.out.println("URL =>+"+req.getRequestURL());
        //i.getRemoteHost()        获取客户端的ip地址
        System.out.println("客户端口IP地址"+req.getRemoteHost());




        //i.getHeader()             获取请求头
        System.out.println("请求头User-Agent"+req.getHeader("User-Agent"));
        //i.getMethod()             获取请求的方式GET或POST
        System.out.println("请求方式"+req.getMethod());

```



##### e)请求的转发

什么是请求的转发

请求转发是指，服务器收到请求后，从一个资源跳转到另一个资源的操作叫做转发











##### f)base标签的作用



![](C:\Users\Administrator\Desktop\MYsql\base标签.PNG)

```html
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <base href="http://localhost:8080/demo_war_exploded/index.jsp">
</head>
<body>

这是webapp下的路径
<a href="index.jsp">跳转首页</a>
<a href="a/b/c.html">form.html</a><br/>
<a href="../../index.jsp">form.html</a><br/>
</body>
</html>
```





##### g)Web中的相对路径和绝对路径

​	在javaweb中，路径分为相对路径和绝对路径两种：

​	相对路径是		；

​        .								表示当前目录

​		..  							  表示上一句目录

​        资源名						表示当前目录/资源名



  绝对路径：

​				http://ip:port/工程路径/资源路径

##### h)Web中 /斜杠的不同意义

   在web中 / 斜杠 是一种绝对路径

​		/  斜杠  如何被浏览器解析，得到的地址是：http://ip:port/

​				<a href="/">斜杠< ?/a>

​		/斜杠 如何被服务器解析，得到的地址是:http://ip:port/工程路径

​           1.<url-pattern>/servlet1</url-pattern>

​			2.Servletcontext.getRealPath("/");

   3. ​      request.getRequestDispatcher("/")

      特殊情况  response.sendRediect("/")  斜杠发送给浏览器解析

### 2.HttpServletResponse类

##### a)HttpServletResponse类的作用

HttpservletResponse类和HttpServletRequest类一样。每次请求进来,Tomcat服务器都会创建一个Response对象传递给Servlet程序去使用。httpServlerRuest表示请求过来的信息,HttpServletResponse表示所有响应的信息,我们如果需要设置返回给客户端的消息,都可以通过HttpServlertResponse对象来进行设置

##### b)两个输出流的说明。

​		字节流         getOutputStream();    常用于下载(传递二进制数据)

​		字符流          getWriter();					常用于回传字符串(常用)

两个流同时只能使用一个

使用了字节流。就不能再使用字符流，反之亦然，否则就会报错。

##### c)如何往客户端回传数据

要求往客户端回传字符串数据

```java
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.print("response  content");


    }
```



##### d)响应的乱码解决



```java
//设置服务器字符集为UTF-8
        resp.setCharacterEncoding("UTF-8");
  第一种方法  resp.setContentType("text/html;charset=UTF-8");
        //它会同时设置服务器和客户端都是用UTF-8
        //此方法一定要在获取流对象之前调用才有效
   第二章   resp.setHeader("Content-Type","text/html;charset=UTF-8");

        //通过响应头设置浏览器也使用UTF-8字符集，还设置了响应头



        System.out.println(resp.getCharacterEncoding());
        PrintWriter writer = resp.getWriter();
        writer.print("你好 顶顶顶顶顶");
```

##### e)请求重定向

​			请求重定向，是指客户端给服务器发送请求，然后服务器告诉客户端说。我给你一些地址。你去新地址访问。叫请求重定向(因为之前的地址可能已经被废弃)

> 有义务告诉客户端，我已搬迁==》》响应码  302
>
> 并且告知新的地址  ==>>			响应头Location
>
> ​       <<====响应状态码  302
>
> ​					Location 响应头，新地址



![](C:\Users\Administrator\Desktop\MYsql\请求重定向.PNG)

请求重定向的特点：

​		1.浏览器地址栏会发生变化

​		 2.两次请求

​          3.不共享Request域中数据（两个Request域）

​		4.不能访问WEB-INF下的资源