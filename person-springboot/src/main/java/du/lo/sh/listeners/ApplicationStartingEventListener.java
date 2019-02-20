package du.lo.sh.listeners;

import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName ApplicationStartingEventListener
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/20 11:27
 * @Version 1.0
 */
public class ApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

    /**
     * 程序运行之前执行
     * @param applicationStartingEvent
     */
    @Override
    public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {

        System.out.println(">>>>>>>>> applicationStartingEvent = [" + applicationStartingEvent + "]");
    }
}
