package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class SpringDeveloper {

    private Address address;

    private Profile profile;

    public SpringDeveloper(Address address, Profile profile) {
        this.address = address;
        this.profile = profile;
    }
}
