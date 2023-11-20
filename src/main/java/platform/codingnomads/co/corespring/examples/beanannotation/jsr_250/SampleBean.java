package platform.codingnomads.co.corespring.examples.beanannotation.jsr_250;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SampleBean {

    public SampleBean() {
        System.out.println("bean is getting ready!");
    }

    @PostConstruct
    public void init() {
        System.out.println("bean @PostConstruct is gathering resources..");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("time to @PreDestroy and head home..");
    }


    @PostConstruct
    public void duringBeanInit(){
        System.out.println("This method is being called during bean creation");
    }

    @PreDestroy
    public void justBeforeDestroyingBean(){
        System.out.println("Just before destroying this bean");
    }
}
