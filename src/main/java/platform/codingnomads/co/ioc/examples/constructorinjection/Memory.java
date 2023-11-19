package platform.codingnomads.co.ioc.examples.constructorinjection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Memory {
    private String manufacturer;
    private int size;
}
