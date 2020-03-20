package de.sanvartis.demo.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Office  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OFFICE_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;


    @OneToMany(mappedBy = "office",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employees;

    public Office() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
