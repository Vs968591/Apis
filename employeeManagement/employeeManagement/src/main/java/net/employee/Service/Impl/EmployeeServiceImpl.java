package net.employee.Service.Impl;
import net.employee.Entity.Employee;
import net.employee.Repository.EmployeeRepository;
import net.employee.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
   private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> saveAllEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @Override
    public Map<String, List<Map<String, Object>>> getEmployeeBonusByCurrency(String date) {
        List<Employee> eligibleEmployees = employeeRepository.findByJoiningDateBeforeAndExitDateAfter(date);
        Map<String, List<Map<String, Object>>> response = new HashMap<>();
        for (Employee employee : eligibleEmployees) {
            String currency = employee.getCurrency();
            if (!response.containsKey(currency)) {
                response.put(currency, new ArrayList<>());
            }
            Map<String, Object> employeeData = new HashMap<>();
            employeeData.put("empName", employee.getEmpName());
            employeeData.put("amount", employee.getAmount());
            response.get(currency).add(employeeData);
        }
        return response;
    }


}
