package platform.codingnomads.co.springdata.example.dml.derivedquerymethods.myexample;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
   Employee findEmployeeByEmailIs(String email);

   Employee findFirstByEmail(String email);

   List<Employee> findEmployeesBySalaryBetween(float min, float max);

   List<Employee> findEmployeesByAgeGreaterThanAndSalaryLessThan(int minAge, float maxSalary);

   List<Employee> findEmployeesByFirstNameContainsIgnoreCase(String firstName);

   List<Employee> getTop10BySalaryLessThan(float salary, Sort sort);


   int countEmployeeBySalaryGreaterThan(float salaray);

}
