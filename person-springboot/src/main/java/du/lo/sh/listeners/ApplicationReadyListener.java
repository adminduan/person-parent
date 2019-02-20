package du.lo.sh.listeners;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName ApplicationReadyListener
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/20 11:43
 * @Version 1.0
 */
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * 命令行执行完成以后调用
     * @param applicationReadyEvent
     */
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println(">>>>>>>>>>>>>> applicationReadyEvent = " + applicationReadyEvent);
    }
}
