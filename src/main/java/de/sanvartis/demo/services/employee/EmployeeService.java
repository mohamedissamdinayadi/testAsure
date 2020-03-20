package de.sanvartis.demo.services.employee;

import de.sanvartis.demo.data.entities.Employee;
import de.sanvartis.demo.data.entities.Office;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> findEmployeeById(Long id);
    void deleteEmployee(Long id);
    List<Employee> getEmployeesByOffice(Office office);

}
