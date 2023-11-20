package platform.codingnomads.co.corespring.examples.autowiredannotation;

import org.springframework.stereotype.Component;

@Component("asusRam")
public class AsusRam implements Memory{
    @Override
    public int size() {
        return 1024;
    }
}
