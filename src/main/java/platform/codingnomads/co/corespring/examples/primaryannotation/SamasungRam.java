package platform.codingnomads.co.corespring.examples.primaryannotation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SamasungRam implements Memory{
    @Override
    public int size() {
        return 1024;
    }
}
