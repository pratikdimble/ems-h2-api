package com.cd;

import com.cd.model.Employee;
import com.cd.repository.EmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class EmsH2Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(EmsH2Application.class, args);
    }

    @Autowired
    EmsRepository emsRepository;
    @Override
    public void run(String... args) throws Exception {
        Employee employee=new Employee();
        employee.setDepartment("DU2");
        employee.setDesignation("Se Dev");
        employee.setJoiningDate(LocalDate.of(2024,11,19));
        employee.setAge(32);
        employee.setName("Jane Doe");
        employee.setAddress("NH4 Shivare Pune");
        emsRepository.save(employee);
    }
}
