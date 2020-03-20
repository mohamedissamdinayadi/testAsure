package de.sanvartis.demo.api;

import de.sanvartis.demo.data.entities.Employee;
import de.sanvartis.demo.data.entities.Office;
import de.sanvartis.demo.services.office.OfficeService;
import de.sanvartis.demo.utils.exceptions.CustomRestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/office")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("/save")
    private Office addOffice(@RequestBody Office office) {
        return officeService.saveOffice(office);
    }

    @GetMapping("/list")
    private List<Office> getAllOffices() {
        return officeService.getAllOffices();
    }

    @PutMapping("/edit/{id}")
    private Office editOffice(@PathVariable("id") Long id, @RequestBody Office office) {
        Office officeById = officeService.findOfficeById(id);
        officeById.setName(office.getName());
        return officeService.saveOffice(officeById);

    }
    @GetMapping("/one/{id}")
    private Office getOfficeById(@PathVariable("id") Long id) {
        return officeService.findOfficeById(id);

    }
    @DeleteMapping("/delete/{id}")
    private void deleteOffice(@PathVariable("id") Long id){
        Office office = officeService.findOfficeById(id);
        officeService.deleteOffice(id);
    }

}
