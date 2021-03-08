package itcode.imp.config;

import itcode.imp.entity.TestEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author imp
 * @date 2021/3/8
 */
@Component
public class EventListener implements ApplicationListener<TestEvent> {

    @Override
    public void onApplicationEvent(TestEvent event) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("收到事件: " + event.getName());
    }
}
