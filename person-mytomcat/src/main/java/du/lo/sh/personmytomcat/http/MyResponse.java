package du.lo.sh.personmytomcat.http;

import java.io.OutputStream;

/**
 * @ClassName MyResponse
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/1/31 14:44
 * @Version 1.0
 */
public class MyResponse {


    private String write;
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public String getWrite(){
        return write;
    }

    public void setWrite(String write){
        this.write = write;
    }
}
