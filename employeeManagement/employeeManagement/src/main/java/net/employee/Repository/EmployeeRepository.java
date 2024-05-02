package net.employee.Repository;
import net.employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    @Query(value = "SELECT * FROM employee WHERE STR_TO_DATE(joining_date, '%b-%d-%Y') <= STR_TO_DATE(?1, '%b-%d-%Y') AND STR_TO_DATE(exit_date, '%b-%d-%Y') >= STR_TO_DATE(?1, '%b-%d-%Y')", nativeQuery = true)
    List<Employee> findByJoiningDateBeforeAndExitDateAfter(String date);
}
