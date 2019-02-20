package du.lo.sh.listeners;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName ApplicationFailedListener
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/20 11:46
 * @Version 1.0
 */
public class ApplicationFailedListener implements ApplicationListener<ApplicationFailedEvent> {
    @Override
    public void onApplicationEvent(ApplicationFailedEvent applicationFailedEvent) {
        System.out.println(">>>>>>>>>>>>> applicationFailedEvent = " + applicationFailedEvent);
        if (applicationFailedEvent.getException() instanceof Exception){
            System.out.println("...................抛出异常");
        }
    }
}
