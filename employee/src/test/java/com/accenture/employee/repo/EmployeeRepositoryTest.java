package com.accenture.employee.repo;

import com.accenture.employee.model.Employee;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository eRepo;

    @Test
    public void create(){
        eRepo.save(new Employee("E7","ENT", "SE", 8, 1500000, "Python","y", "P1","Delhi"));
        assertNotNull(eRepo.findById("E7"));
        }

    @Test
    public void find(){
        assertEquals("Sid", eRepo.findById("E1").get().getName());
    }

    @Test
    public void find_all(){
        assertThat(eRepo.findAll()).size().isGreaterThan(0);
    }

    @Test
    public void update(){
        Employee e = eRepo.findById("E1").get();
        e.setLocation("Hyderabad");
        eRepo.save(e);
        System.out.println(eRepo.findById("E1").get().getLocation());
        assertEquals("Hyderabad", eRepo.findById("E1").get().getLocation());

    }
    @Test
    public void delete(){
        eRepo.save(new Employee("E7","ENT", "SE", 8, 1500000, "Python","y", "P1","Delhi"));
        eRepo.deleteById("E7");
        assertThat(eRepo.existsById("E7")).isFalse();
    }
}