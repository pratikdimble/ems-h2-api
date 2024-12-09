package com.cd;

import com.cd.model.Employee;
import com.cd.repository.EmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        Employee employee2=new Employee();
        employee2.setDepartment("DU1");
        employee2.setDesignation("Jr Dev");
        employee2.setJoiningDate(LocalDate.of(2024,11,29));
        employee2.setAge(22);
        employee2.setName("San Andros");
        employee2.setAddress("NH2 Delhi Delhi6");
        List<Employee> list = new ArrayList<>();
        list.add(employee);
        list.add(employee2);
        emsRepository.saveAll(list);
    }
}
