package ex3.processor;

import ex2.ServletProcess;
import ex2.StaticResourceProcesor;
import ex3.processor.http.HttpRequest;
import ex3.processor.http.HttpResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @program: mytomcat
 * @description: 请求处理器
 * @author: zhaoxudong
 * @create: 2020-05-31 19:29
 **/
public class HttpProcessor {

//    protected StringManager sm =
//            StringManager.getManager("ex03.pyrmont.connector.http");
    /**
     * 请求处理方法
     *
     * @param accept
     */
    public void process(Socket accept) {
        SocketInputStream socketInputStream = null;
        OutputStream outputStream = null;
        try {
            InputStream inputStream = accept.getInputStream();
            outputStream = accept.getOutputStream();
            // 创建 httprequest 和 httpresponse
            socketInputStream = new SocketInputStream(inputStream, 2048);
            // 创建 httprequest
            HttpRequest httpRequest = new HttpRequest(socketInputStream);
            // 创建 httpresponse
            HttpResponse httpResponse = new HttpResponse(outputStream);
            httpResponse.setRequest(httpRequest);
//            httpResponse.setHeader(("Server", "Pyrmont Servlet Container");
//            // 处理inputstream 和 outputstream
//            parseRequest(inputStream, outputStream);
//            // 处理头部信息
//            parseHeader(inputStream);
            // 如果是servlet ，交给servletProcess 处理
            // 根据不同到情况处理
            if (httpRequest.getUri().startsWith("/servlet/")) {
                ServletProcess servletProcess = new ServletProcess();
//                servletProcess.process(httpRequest, httpResponse);

            } else {
                StaticResourceProcesor staticResourceProcesor = new StaticResourceProcesor();
//                staticResourceProcesor.process(httpRequest, httpResponse);
            }

            accept.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
