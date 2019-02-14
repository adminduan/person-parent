package du.lo.sh.personmytomcat.http;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @ClassName MyRequest
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/1/31 14:44
 * @Version 1.0
 */
public class MyRequest {

    @Getter
    @Setter
    private String method;

    @Setter
    @Getter
    private String url;

    public MyRequest(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String str = bufferedReader.readLine();
        String[] methodAndUrl = str.split(" ");
        this.method = methodAndUrl[0];
        this.url = methodAndUrl[1];
        System.out.println("请求类型：" + method);
        System.out.println("请求地址：" + url);

    }
}
