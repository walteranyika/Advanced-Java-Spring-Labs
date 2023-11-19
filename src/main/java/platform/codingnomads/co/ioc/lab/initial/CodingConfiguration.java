package platform.codingnomads.co.ioc.lab.initial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("platform.codingnomads.co.ioc.lab.initial")
public class CodingConfiguration {
    @Bean
    public Framework framework(){
        return  Framework.builder().name("Spring Boot").version("3.0.0").build();
    }

    @Bean
    public  IDE ide(){
        return  IDE.builder().name("IntelliJ Ultimate Edition").version("2023.1").build();
    }

    @Bean
    public JDK jdk(){
        return  JDK.builder().name("Java OpenJDK").version("11").build();
    }
}
