package du.lo.sh.personmytomcat.servlet;

import du.lo.sh.personmytomcat.http.MyRequest;
import du.lo.sh.personmytomcat.http.MyResponse;

/**
 * @ClassName MyServlet
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/1/31 16:14
 * @Version 1.0
 */
public class MyServlet extends AbstractServlet {


    @Override
    public void doGet(MyRequest request, MyResponse response) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>doGet<<<<<<<<<<<<<<<<<<<<<");
        response.setWrite("我的第一个servlet");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>doPost<<<<<<<<<<<<<<<<<<<<<");
        this.doGet(request,response);
    }
}
