package du.lo.sh.personmytomcat.tomcat;

import du.lo.sh.personmytomcat.process.SocketProcess;
import du.lo.sh.personmytomcat.util.XmlUtils;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Tomcat
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/1/31 16:20
 * @Version 1.0
 */
@Slf4j
public class MyTomcat {

//    private static final Logger log = LoggerFactory.getLogger(MyTomcat.class);

    public static final Map<String, Object> SERVLET = new HashMap<>();
    public static final Map<String, String> SERVLET_MAPPING = new HashMap<>();

    private void init(){


        try {
            log.info(">>>>>>>>>>>>>>>>开始加载配置文件开始<<<<<<<<<<<<<<<<<<<<<<");
            XmlUtils xmlUtils = new XmlUtils(new File(ClassLoader.getSystemResource("web.xml").getPath()));
            List<Element> elements = xmlUtils.getNodes("servlet");
            for (Element e : elements){
                SERVLET.put(e.element("servlet-name").getText(), Class.forName(e.element("servlet-class").getText()).newInstance());
            }

            List<Element> elementMapping = xmlUtils.getNodes("servlet-mapping");
            for (Element e : elementMapping){
                SERVLET_MAPPING.put(e.element("url-pattern").getText(), e.element("servlet-name").getText());
            }

            System.out.println(SERVLET);
            System.out.println(SERVLET_MAPPING);
            log.info(">>>>>>>>>>>>>>>>开始加载配置文件结束<<<<<<<<<<<<<<<<<<<<<<");
        } catch (ClassNotFoundException e1) {
            log.error("ClassNotFoundException error", e1);
        } catch (IllegalAccessException e) {
            log.error("ClassNotFoundException error", e);
        } catch (InstantiationException e) {
            log.error("ClassNotFoundException error", e);
        } finally {

        }

    }


    public void start(){
        try {
            int port = 9999;
            ServerSocket serverSocket = new ServerSocket(port);
            log.info("服务启动端口: {}", port);
            init();
            while (true){
                Socket socket = serverSocket.accept();
                new SocketProcess(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyTomcat().start();
    }
}
