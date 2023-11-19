package platform.codingnomads.co.corespring.examples.application_context.customeventlistener;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyUserRegCompletedListener implements ApplicationListener<UserRegistrationCompletedEvent> {
    @Override
    public void onApplicationEvent(UserRegistrationCompletedEvent event) {
        System.out.println("I am a second listener");
    }
}
