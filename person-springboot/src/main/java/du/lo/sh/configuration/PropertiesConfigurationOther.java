package du.lo.sh.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName PropertiesConfigurationOther
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/22 10:37
 * @Version 1.0
 */
public class PropertiesConfigurationOther {

    @Value("${name}")
    private String value;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
