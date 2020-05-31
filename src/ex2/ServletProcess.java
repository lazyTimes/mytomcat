package ex2;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * @program: mytomcat
 * @description: servlet处理器
 * @author: zhaoxudong
 * @create: 2020-05-29 22:19
 **/
public class ServletProcess {
    public void process(HttpRequest request, HttpResponse response) {
        String uri = request.getUri();
        String serveletName = uri.substring(uri.lastIndexOf("/") + 1);
        // 创建Url加载器
        URL[] urls = new URL[1];
        File classPath = new File(Constants.WEBROOT);
        URLClassLoader loader = null;
        try {
            URLStreamHandler streamHandler = null;
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        Class myclass = null;
        try {
            myclass = loader.loadClass(serveletName);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }

        Servlet servlet = null;
        //使用face 封装
        RequestFace requestFace = new RequestFace(request);
        ResponseFace responseFace = new ResponseFace(response);
        try {
            servlet = (Servlet) myclass.newInstance();
            servlet.service(requestFace, responseFace);

        } catch (InstantiationException | IllegalAccessException | ServletException | IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
