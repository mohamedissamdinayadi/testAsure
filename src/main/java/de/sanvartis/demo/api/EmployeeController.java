package de.sanvartis.demo.api;

import de.sanvartis.demo.data.entities.Employee;
import de.sanvartis.demo.data.entities.Office;
import de.sanvartis.demo.services.employee.EmployeeService;
import de.sanvartis.demo.services.office.OfficeService;
import de.sanvartis.demo.utils.exceptions.CustomRestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/employee")

public class EmployeeController {
    private final EmployeeService employeeService;
    private final OfficeService officeService;

    public EmployeeController(EmployeeService employeeService, OfficeService officeService) {
        this.employeeService = employeeService;
        this.officeService = officeService;
    }


    @PostMapping("/save")
    private Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/list")
    private List<Employee> getAllEmployees(@RequestParam(required = false) Long office) {
        if (office == null) {
            return employeeService.getAllEmployees();
        } else {
            Office officeById = this.officeService.findOfficeById(office);
            return this.employeeService.getEmployeesByOffice(officeById);
        }

    }

    @PutMapping("/edit/{id}")
    private Employee editEmployee(@PathVariable("id") Long id, @RequestBody Employee employee) {
        Employee employeeById = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new CustomRestException("employee not found", HttpStatus.BAD_REQUEST));
        employeeById.setName(employee.getName());
        employeeById.setEmail(employee.getEmail());
        employeeById.setBirthday(employee.getBirthday());
        employeeById.setMarried(employee.getMarried());
        employeeById.setJobTitle(employee.getJobTitle());
        return employeeService.saveEmployee(employeeById);

    }

    @GetMapping("/one/{id}")
    private Employee getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findEmployeeById(id)
                .orElseThrow(() -> new CustomRestException("employee not found", HttpStatus.BAD_REQUEST));

    }

    @DeleteMapping("/delete/{id}")
    private void deleteEmployee(@PathVariable("id") Long id) {
        Employee employee = employeeService.findEmployeeById(id)
                .orElseThrow(() -> new CustomRestException("employee not found", HttpStatus.BAD_REQUEST));
        employeeService.deleteEmployee(id);
    }

    @GetMapping("testAzure")
    private String testAzure (){
        return "hello phoenix-its sfax ";
    }
}
