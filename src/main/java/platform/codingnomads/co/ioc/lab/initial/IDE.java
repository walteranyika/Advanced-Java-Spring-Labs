package platform.codingnomads.co.ioc.lab.initial;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IDE {
    private String name;
    private String version;
}
