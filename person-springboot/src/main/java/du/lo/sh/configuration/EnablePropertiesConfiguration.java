package du.lo.sh.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @ClassName EnablePropertiesConfiguration
 * @Description 允许properties配置
 * @Author duanlsh
 * @Date 2019/2/22 10:23
 * @Version 1.0
 */
@Configuration
@Slf4j
//@EnableConfigurationProperties(PropertiesConfiguration.class)
public class EnablePropertiesConfiguration {

    @ConfigurationProperties(prefix = "environments")
    @Bean
    public PropertiesConfigurationOther propertiesConfigurationOther(){
        return new PropertiesConfigurationOther();
    }

    @PostConstruct
    public void init(){

        System.out.println(propertiesConfigurationOther().getValue());
        while (true){
            log.info("MysqlConnect.init1");
            log.info("MysqlConnect.init2");
            log.info("MysqlConnect.init3");
            log.info("MysqlConnect.init4");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
