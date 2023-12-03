package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LifecycleCallbackDemo {

    @Autowired
    PrintEntityRepository printEntityRepository;
    public static void main(String[] args) {
        SpringApplication.run(LifecycleCallbackDemo.class);
    }

    @Bean
    public CommandLineRunner runStuff(PrintEntityRepository printEntityRepository) {
        return (args) -> {
            // put your logic here
            PrintEntity printEntity1= PrintEntity.builder().title("silver magic stick").build();
            PrintEntity printEntity2= PrintEntity.builder().title("bright northern star").build();
            PrintEntity printEntity3= PrintEntity.builder().title("blue  midnight moon").build();

            printEntityRepository.saveAll(List.of(printEntity1, printEntity2, printEntity3));

            PrintEntity entityToUpdate = printEntityRepository.findAll().iterator().next();
            System.out.println(entityToUpdate.getFormattedTitle());
            entityToUpdate.setTitle("silver magic bullet");
            printEntityRepository.save(entityToUpdate);
            //323458
            //972220800

        };
    }
}
