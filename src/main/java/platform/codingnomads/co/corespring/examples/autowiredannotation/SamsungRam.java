package platform.codingnomads.co.corespring.examples.autowiredannotation;

import org.springframework.stereotype.Component;

@Component("samsungRam")
public class SamsungRam implements Memory{
    @Override
    public int size() {
        return 512;
    }
}
