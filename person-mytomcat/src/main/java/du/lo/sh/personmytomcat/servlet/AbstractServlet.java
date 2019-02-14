package du.lo.sh.personmytomcat.servlet;

import du.lo.sh.personmytomcat.http.MyRequest;
import du.lo.sh.personmytomcat.http.MyResponse;

/**
 * @ClassName AbstractServlet
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/1/31 16:13
 * @Version 1.0
 */
public abstract class AbstractServlet {


    public abstract void doGet(MyRequest request, MyResponse response);

    public abstract  void doPost(MyRequest request, MyResponse response);

}
