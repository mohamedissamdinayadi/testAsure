package de.sanvartis.demo.services.office;

import de.sanvartis.demo.data.entities.Employee;
import de.sanvartis.demo.data.entities.Office;

import java.util.List;
import java.util.Optional;

public interface OfficeService {
    Office saveOffice(Office office);
    List<Office> getAllOffices();
    Office findOfficeById(Long id);
    void deleteOffice(Long id);

}
