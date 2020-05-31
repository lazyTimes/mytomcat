package ex1;

import ex2.Constants;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @program: mytomcat
 * @description: http响应体
 * @author: zhaoxudong
 * @create: 2020-05-24 20:35
 **/
public class HttpResponse {

    /**
     * 组合httprequest
     * 根据request返回对应到信息
     */
    private HttpRequest request;

    /**
     * 输出流
     */
    private OutputStream outputStream;

    /**
     * 缓冲区大小
     */
    private static final int BUFFER_COUNT = 1024;


    public HttpResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /**
     * 设置静态资源
     */
    public void setResource() throws IOException {
        String errMsg = "404 msg";
        // 字节缓存区
        byte[] bytes = new byte[BUFFER_COUNT];
        // 读取静态资源
        File file = new File(Constants.WEBROOT, request.getUri());
        if (file.exists()) {
            // 文件流
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                // 读取字节
                int ch = fileInputStream.read(bytes, 0, BUFFER_COUNT);
                // 输出
                while (ch != -1) {
                    // 写入流
                    outputStream.write(bytes, 0, ch);
                    // 重复读取数据到缓冲区
                    ch = fileInputStream.read(bytes, 0, BUFFER_COUNT);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } else {
            try {
                outputStream.write(errMsg.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (outputStream != null) {
                    outputStream.close();
                }
            }
        }
    }

    /**
     * 设置request
     *
     * @param httpRequest
     */
    public void setRequest(HttpRequest httpRequest) {
        this.request = httpRequest;
    }
}
