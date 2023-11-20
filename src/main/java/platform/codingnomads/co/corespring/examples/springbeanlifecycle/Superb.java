package platform.codingnomads.co.corespring.examples.springbeanlifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class Superb implements BeanNameAware {
    @Override
    public void setBeanName(String name) {
        System.out.println("Calling in from pluto to tell you that I am "+name);
    }
}
