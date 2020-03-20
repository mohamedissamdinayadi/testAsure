package de.sanvartis.demo.services.employee;

import de.sanvartis.demo.data.dao.EmployeeRepository;
import de.sanvartis.demo.data.entities.Employee;
import de.sanvartis.demo.data.entities.Office;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {
private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public List<Employee> getEmployeesByOffice(Office office) {
        return this.employeeRepository.findAllByOffice(office);
    }

}
