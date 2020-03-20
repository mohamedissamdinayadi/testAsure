package de.sanvartis.demo.data.dao;

import de.sanvartis.demo.data.entities.Employee;
import de.sanvartis.demo.data.entities.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    List<Employee> findAllByOffice(Office office);
}
