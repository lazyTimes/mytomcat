package ex2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: mytomcat
 * @description: HttpServer ，充当请求的连接器和容器
 * @author: zhaoxudong
 * @create: 2020-05-24 19:42
 **/
public class HttpServer1 {

    /**
     * 关闭容器的请求路径
     */
    private static final String SHUTDOWN = "/SHUTDOWN";



    /**
     * 是否关闭标识
     */
    private boolean SHUTDOWN_FLAG = false;

    public static void main(String[] args) {
        new HttpServer1().await();
    }

    /**
     * 具体的server 方法，等待socket请求
     */
    public void await() {
        // 默认为8080端口
        int port = 8080;
        String host = "127.0.0.1";
        ServerSocket serverSocket = null;
        try {
            // 创建套接字
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName(host));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        while (!SHUTDOWN_FLAG) {
            try {
                // 等待套接字
                Socket accept = serverSocket.accept();
                ex2.HttpRequest httpRequest = new ex2.HttpRequest(accept.getInputStream());
                // 处理请求数据
                httpRequest.parse();
                // 创建响应对象，处理响应信息
                ex2.HttpResponse httpResponse = new ex2.HttpResponse(accept.getOutputStream());
                // 设置静态资源
                httpResponse.setRequest(httpRequest);
                httpResponse.setResource();
                // 根据不同到情况处理
                if(httpRequest.getUri().startsWith("/servlet/")){
                    ServletProcess servletProcess = new ServletProcess();
                    servletProcess.process(httpRequest, httpResponse);

                }else{
                    StaticResourceProcesor staticResourceProcesor = new StaticResourceProcesor();
                    staticResourceProcesor.process(httpRequest, httpResponse);
                }
                // 关闭的套接字
                accept.close();
                // 判断请求Url是否为 /shutdown
                SHUTDOWN_FLAG = httpRequest.getUri().equalsIgnoreCase(SHUTDOWN);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }

    }
}
