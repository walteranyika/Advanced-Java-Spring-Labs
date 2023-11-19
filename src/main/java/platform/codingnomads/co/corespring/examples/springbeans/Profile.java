package platform.codingnomads.co.corespring.examples.springbeans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Profile {
    private String language;
    private int yearsOfExperience;
}
