package platform.codingnomads.co.ioc.examples.setterinjection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class HardDrive {
    private String manufacturer;
    private int size;
}
