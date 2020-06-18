package ex2;

import java.io.IOException;
import java.time.LocalDate;

/**
 * 自己出里的逻辑
 * @program: mytomcat
 * @description: 静态资源处理器
 * @author: zhaoxudong
 * @create: 2020-05-29 21:55
 **/
public class StaticResourceProcesor {


    public static void main(String[] args) {
    }

    public void process(HttpRequest request, HttpResponse response){
        try {
            response.setResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
