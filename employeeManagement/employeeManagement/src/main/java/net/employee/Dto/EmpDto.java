package net.employee.Dto;

import lombok.Data;
import net.employee.Entity.Employee;

import java.util.List;
@Data
public class EmpDto {
    List<Employee> employees;
}
