package platform.codingnomads.co.springdata.example.springdatajdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringDataJDBCDemo implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJDBCDemo.class);
    }

    @Override
    public void run(String... strings) {

        try {
            //create employee table using the JdbcTemplate method "execute"
            jdbcTemplate.execute("CREATE TABLE employees (id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                    "first_name VARCHAR(255) NOT NULL,last_name  VARCHAR(255) NOT NULL);");

            jdbcTemplate.execute("CREATE TABLE `cars` (\n" +
                    "\t`id` INT(10) NOT NULL AUTO_INCREMENT,\n" +
                    "\t`make` VARCHAR(50),\n" +
                    "\t`model` VARCHAR(50),\n" +
                    "\t`price` INT(8),\n" +
                    "\tPRIMARY KEY (`id`)\n" +
                    ")");
        } catch (Exception e) {
            //nothing
        }

        //create a list of first and last names
        List<Object[]> splitUpNames = Stream.of("Java Ninja", "Spring Guru", "Java Guru", "Spring Ninja")
                .map(name -> name.split(" "))
                .collect(Collectors.toList());

        Car car_1 = new Car("Toyota", "Prado", 3000000);
        Car car_2 = new Car("Nissan", "Sunny", 12000000);
        Car car_3 = new Car("Mercedes", "Mayback", 4000000);

        List<Car> cars = List.of(car_1, car_2,car_3);
        cars.forEach(car->jdbcTemplate.execute(String.format("INSERT INTO cars (make, model, price) VALUES('%s', '%s', '%d')",
                car.getMake(), car.getModel(), car.getPrice())));


        //for each first & last name pair insert an Employee into the database
        for (Object[] name : splitUpNames) {
            jdbcTemplate.execute(String.format("INSERT INTO employees(first_name, last_name) VALUES ('%s','%s')", name[0], name[1]));
        }

        //query the database for Employees with first name Java
        jdbcTemplate.query(
                        "SELECT id, first_name, last_name FROM employees WHERE first_name = 'Java'",
                        (rs, rowNum) -> new Employee(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name"))
                )
                //print each found employee to the console
                .forEach(employee -> System.out.println(employee.toString()));


        jdbcTemplate.query("SELECT * FROM cars", (rs, rowNum) ->new Car(rs.getLong("id"), rs.getString("make"), rs.getString("model"), rs.getInt("price"))).forEach(car-> System.out.println(car.toString()));

        //truncate the table
        jdbcTemplate.execute("TRUNCATE TABLE employees;");
        jdbcTemplate.execute("TRUNCATE TABLE cars;");
        //delete the table
        jdbcTemplate.execute("DROP TABLE employees");
        jdbcTemplate.execute("DROP TABLE cars");
    }
}
