package de.sanvartis.demo.services.office;

import de.sanvartis.demo.data.dao.OfficeRepository;
import de.sanvartis.demo.data.entities.Employee;
import de.sanvartis.demo.data.entities.Office;
import de.sanvartis.demo.utils.exceptions.CustomRestException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeServiceImp implements OfficeService {

    private final OfficeRepository officeRepository;

    public OfficeServiceImp(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public Office saveOffice(Office office) {
        return this.officeRepository.save(office);
    }

    @Override
    public List<Office> getAllOffices() {
        return this.officeRepository.findAll();
    }

    @Override
    public Office findOfficeById(Long id) {
        return this.officeRepository.findById(id)
                .orElseThrow(() -> new CustomRestException("office not found", HttpStatus.BAD_REQUEST));
    }

    @Override
    public void deleteOffice(Long id) {
        this.officeRepository.deleteById(id);
    }


}
