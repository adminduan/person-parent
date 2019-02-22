package du.lo.sh.configuration;

import du.lo.sh.bean.MyBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PropertiesConfiguration
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/20 16:16
 * @Version 1.0
 */

@Component
@ConfigurationProperties(prefix = "environments")
@Validated
public class PropertiesConfiguration {

    @Value("${name}")
    private String value;

    @Value("${my.secret}")
    private String secret;

    @Value("${my.number}")
    private String myValue;

    @Value("${my.bignumber}")
    private String bigNumber;

    @Value("${my.uuid}")
    private String uuid;

    @Value("${my.number.less.then.ten}")
    private String lessThanTen;

    @Value("${my.number.in.range}")
    private String inRange;


    private Map<String, String> prod ;//= new HashMap<>();
    private List<String> servers = new ArrayList<>();

    @NotNull
    private List<MyBean> myBeans;

    public void setProd(HashMap<String, String> prod) {
        this.prod = prod;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

    public void setMyBeans(List<MyBean> myBeans) {
        this.myBeans = myBeans;
    }

    @PostConstruct
    public void init(){
        System.out.println(">>>>> " + value);

        System.out.println(">>>>>>" + secret);
        System.out.println(">>>>>>" + myValue);
        System.out.println(">>>>>>" + bigNumber);
        System.out.println(">>>>>>" + uuid);
        System.out.println(">>>>>>" + lessThanTen);
        System.out.println(">>>>>>" + inRange);
        System.out.println(">>>>>>" + prod);
        System.out.println(">>>>>>" + servers);
        System.out.println(">>>>>>" + myBeans);
    }
}
