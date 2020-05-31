package ex3.processor;

import java.io.InputStream;

/**
 * @program: mytomcat
 * @description: 套接字输入流
 * @author: zhaoxudong
 * @create: 2020-05-31 20:01
 **/
public class SocketInputStream {

    private InputStream inputStream;

    private int bufferSize;

    /**
     * 套接字input stream 构建起
     * @param inputStream input stream
     * @param bufferSize 缓冲区大小
     */
    public SocketInputStream(InputStream inputStream, int bufferSize) {
        this.inputStream = inputStream;
        this.bufferSize = bufferSize;
    }


}
