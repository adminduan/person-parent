package du.lo.sh.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @ClassName PropertiesConfiguration
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/20 16:16
 * @Version 1.0
 */
@Component
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

    @Value("${environments.dev.url}")
    private String inRange;

    @Value("${environments.dev}")
    private Map<String, String> ymlToParam;

    @PostConstruct
    public void init(){
        System.out.println(">>>>> " + value);

        System.out.println(">>>>>>" + secret);
        System.out.println(">>>>>>" + myValue);
        System.out.println(">>>>>>" + bigNumber);
        System.out.println(">>>>>>" + uuid);
        System.out.println(">>>>>>" + lessThanTen);
        System.out.println(">>>>>>" + inRange);
        System.out.println(">>>>>>" + ymlToParam);
    }
}
