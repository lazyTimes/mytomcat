package ex1;

import java.io.IOException;
import java.io.InputStream;

/**
 * @program: mytomcat
 * @description: httprequest请求对象
 * @author: zhaoxudong
 * @create: 2020-05-24 20:08
 **/
public class HttpRequest {

    /**
     * 缓冲区的大小为 1M
     */
    private static final int BUFFER_COUNT = 1024;

    /**
     * 请求路径
     */
    private String uri;

    /**
     * 请求流
     */
    private InputStream inputStream;

    public HttpRequest(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    /**
     * 解析inputstream 对于内容进行解析
     */
    public void parse() {
        // 字符串缓冲池
        StringBuffer stringBuffer = new StringBuffer(BUFFER_COUNT);

        byte[] byteBuffer = new byte[BUFFER_COUNT];

        if (inputStream == null) {
            System.err.println("未找到套接字");
            return;
        }

        int read = 0;
        try {
            // 读取数据到byte数组
            read = inputStream.read(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        //读取byte数组的数据进入到stringbuffer
        for (int i = 0; i < read; i++) {

            stringBuffer.append((char)byteBuffer[i]);
        }
        // 打印stringbuffer
        System.err.println(stringBuffer.toString());
        // 获取uri
        uri = parseUri(stringBuffer.toString());
    }

    /**
     * 解析请求，获取请求Uri
     * @param requestString 需要处理的uri
     */
    public String parseUri(String requestString){
        // 建立index1 和 2
        int index1, index2;
        // 获取到第一个空行
        index1 = requestString.indexOf(' ');
        if(index1 != -1){
            // 从index1 开始找
            index2 = requestString.indexOf(' ', index1 + 1);
            if(index2 > index1){
                // 获取请求路径
                return requestString.substring(index1 + 1, index2);
            }
        }
        return null;

    }


    public String getUri() {
        return uri;
    }
}
