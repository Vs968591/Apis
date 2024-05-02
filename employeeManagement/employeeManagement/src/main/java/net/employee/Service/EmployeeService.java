package net.employee.Service;

import net.employee.Entity.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService{
     List<Employee> saveAllEmployees(List<Employee> employees);

     public Map<String, List<Map<String, Object>>> getEmployeeBonusByCurrency(String date);

}
