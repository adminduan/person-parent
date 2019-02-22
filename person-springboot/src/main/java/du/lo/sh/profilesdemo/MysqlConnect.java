package du.lo.sh.profilesdemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName MysqlConnect
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/22 15:29
 * @Version 1.0
 */
@Component
@Profile("mysql")
public class MysqlConnect {


    @PostConstruct
    public void init(){
        System.out.println("MysqlConnect.init");
    }
}
