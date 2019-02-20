package du.lo.sh.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @ClassName CommonConfiguration
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/20 13:58
 * @Version 1.0
 */
@Configuration
public class CommonConfiguration {


    /**
     * 获取main方法传递的参数信息
     * @param arguments
     */
    public CommonConfiguration(ApplicationArguments arguments){

        boolean flag = arguments.containsOption("debug");
        List<String> paramList = arguments.getNonOptionArgs();
        System.out.println("init");
    }
}
