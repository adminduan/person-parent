package du.lo.sh.listeners;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName MyListener
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/20 11:14
 * @Version 1.0
 */
public class MyListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {


    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent applicationEnvironmentPreparedEvent) {
        System.out.println(">>>>>>>>>>> applicationEnvironmentPreparedEvent = " + applicationEnvironmentPreparedEvent);
    }

}
