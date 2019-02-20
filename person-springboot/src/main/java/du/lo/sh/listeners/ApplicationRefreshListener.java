package du.lo.sh.listeners;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName ApplicationRefreshListener
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/20 11:35
 * @Version 1.0
 */
public class ApplicationRefreshListener implements ApplicationListener<ApplicationPreparedEvent> {
    @Override
    public void onApplicationEvent(ApplicationPreparedEvent applicationPreparedEvent) {
        System.out.println(">>>>  applicationPreparedEvent = " + applicationPreparedEvent);
    }
}
