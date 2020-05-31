package ex3;

import ex3.processor.HttpProcessor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: mytomcat
 * @description: Http连接器
 * @author: zhaoxudong
 * @create: 2020-05-31 17:56
 **/
public class HttpConnector implements Runnable  {

    private static final int PORT = 8080;

    boolean stopped = false;

    private String schme = "http";
    /**
     * ip 地址
     */
    private static final String HOST = "127.0.0.1";

    public void start(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        try {
            // 创建套接字
            serverSocket = new ServerSocket(PORT, 1, InetAddress.getByName(HOST));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        while(!stopped){
            Socket accept = null;
            try {
                accept = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 创建 HttpProcessor 处理器
            HttpProcessor httpProcessor = new HttpProcessor();
            httpProcessor.process(accept);
        }
    }
}
