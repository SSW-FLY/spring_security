package itcode.imp.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author imp
 * @date 2021/3/8
 */
@Getter
@Setter
public class TestEvent extends ApplicationEvent {

    private String name;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public TestEvent(Object source,String name) {
        super(source);
        this.name = name;
    }
}
