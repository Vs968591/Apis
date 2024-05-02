package net.employee.Controller;
import net.employee.Dto.EmpDto;
import net.employee.Entity.Employee;
import net.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/tci")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee-bonus")
    public ResponseEntity<List<Employee>> calculateEmployeeBonus(@RequestBody EmpDto empDto){
        try{
            List<Employee> savedEmployees = employeeService.saveAllEmployees(empDto.getEmployees());
            return new ResponseEntity<>(savedEmployees,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/employee-bonus")
    public ResponseEntity<Map<String, List<Map<String, Object>>>> getEligibleEmployees(@RequestParam("date") String date) {
        try {
            Map<String, List<Map<String, Object>>> employeeBonusByCurrency = employeeService.getEmployeeBonusByCurrency(date);
            if (employeeBonusByCurrency.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return new ResponseEntity<>(employeeBonusByCurrency,HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
