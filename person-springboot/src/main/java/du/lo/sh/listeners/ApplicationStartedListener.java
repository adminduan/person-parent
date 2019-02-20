package du.lo.sh.listeners;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @ClassName ApplicationStartedListener
 * @Description TODO
 * @Author duanlsh
 * @Date 2019/2/20 11:38
 * @Version 1.0
 */
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {

    /**
     * 启动完成以后 命令行关闭之前调用
     * @param applicationStartedEvent
     */
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        System.out.println(">>>>>> applicationStartedEvent = " + applicationStartedEvent);
    }
}
