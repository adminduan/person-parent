package du.lo.sh.profilesdemo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName OracleConnect
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/22 15:29
 * @Version 1.0
 */
@Component
@Profile("oracle")
public class OracleConnect {

    @PostConstruct
    public void init(){
        System.out.println("OracleConnect.init");
    }
}
