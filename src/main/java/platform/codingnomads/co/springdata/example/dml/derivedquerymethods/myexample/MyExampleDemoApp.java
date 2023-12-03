package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class MyExampleDemoApp implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyExampleDemoApp.class);
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        long recordCount = employeeRepository.count();

        if (recordCount == 0) {
            String[] models = new String[]{"Toyota", "Mercedes", "Honda", "Mazda", "Rolls Royce", "Ferrari", "Lamborgini","Ford","Chevrolet", "Mitsubishi"};
            for (int i = 0; i < 100; i++) {
                Employee employee = Employee.builder()
                        .firstName(faker.name().firstName())
                        .lastName(faker.name().lastName())
                        .email(faker.internet().emailAddress())
                        .phone(faker.numerify("072#######"))
                        .age(faker.random().nextInt(18, 71))
                        .salary(faker.random().nextInt(10000, 80000).floatValue())
                        .yearsOfExperience(faker.random().nextInt(1, 15))
                        .build();
                Employee savedInstance =employeeRepository.save(employee);

                Car car = Car.builder()
                        .make(models[faker.random().nextInt(0,10)])
                        .plate("KAZ "+ faker.numerify("###"))
                        .build();
                savedInstance.cars.add(car);
                employeeRepository.save(employee);
            }
        }

        Employee employee = employeeRepository.findEmployeeByEmailIs("timothy.ferry@gmail.com");
        System.out.println(employee);

        Employee employeeByEmail = employeeRepository.findFirstByEmail("andre.waters@yahoo.com");
        System.out.println(employeeByEmail);

        System.out.println("---------findEmployeesBySalaryBetween----------");
        employeeRepository.findEmployeesBySalaryBetween(10000f, 15000f).forEach(System.out::println);
        System.out.println("---------findEmployeesByAgeGreaterThanAndSalaryLessThan----------");
        employeeRepository.findEmployeesByAgeGreaterThanAndSalaryLessThan(46, 16000f).forEach(System.out::println);
        System.out.println("---------findEmployeesByFirstNameContainsIgnoreCase----------");
        employeeRepository.findEmployeesByFirstNameContainsIgnoreCase("ter").forEach(System.out::println);
        System.out.println("---------getTop10BySalaryLessThan----------");
        employeeRepository.getTop10BySalaryLessThan(15000f, Sort.by("salary")).forEach(System.out::println);
    }
}
