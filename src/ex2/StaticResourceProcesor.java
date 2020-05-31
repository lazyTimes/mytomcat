package ex2;

import java.io.IOException;

/**
 * @program: mytomcat
 * @description: 静态资源处理器
 * @author: zhaoxudong
 * @create: 2020-05-29 21:55
 **/
public class StaticResourceProcesor {

    public void process(HttpRequest request, HttpResponse response){
        try {
            response.setResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
