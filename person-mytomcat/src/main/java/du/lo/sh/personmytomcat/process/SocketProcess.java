package du.lo.sh.personmytomcat.process;

import du.lo.sh.personmytomcat.http.MyRequest;
import du.lo.sh.personmytomcat.http.MyResponse;
import du.lo.sh.personmytomcat.servlet.AbstractServlet;
import du.lo.sh.personmytomcat.tomcat.MyTomcat;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ClassName SocketProcess
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/1/31 16:34
 * @Version 1.0
 */
public class SocketProcess extends Thread{

    protected Socket socket;

    public static final String RESPONSE_HEADER ="HTTP/1.1 200 \r\n"
            + "Content-Type: text/html\r\n"
            + "\r\n";

    public SocketProcess(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            System.out.println("开始处理---------------");
            MyRequest myRequest = new MyRequest(socket.getInputStream());
            MyResponse myResponse = new MyResponse(socket.getOutputStream());

            String servletName = MyTomcat.SERVLET_MAPPING.get(myRequest.getUrl());
            if (servletName != null && !servletName.isEmpty()){
                AbstractServlet abstractServlet = (AbstractServlet) MyTomcat.SERVLET.get(servletName);
                if (abstractServlet != null){
                    abstractServlet.doGet(myRequest, myResponse);
                } else {
                    System.out.println("没有对应的servlet");
                }
            } else {
                System.out.println("找不到对应的servlet-mapping");
            }

            String write = RESPONSE_HEADER + myResponse.getWrite();
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(write.getBytes("gbk"));
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
