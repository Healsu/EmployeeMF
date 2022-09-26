package com.example.employeemf;

import com.example.employeemf.model.EmployeeEntity;
import com.example.employeemf.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EmployeeMfApplication {
    private static final Logger log = LoggerFactory.getLogger(EmployeeMfApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EmployeeMfApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(EmployeeRepository employeeRepository){

        return (args) -> {
            final List<EmployeeEntity> employees = new ArrayList<>();
            employees.add(new EmployeeEntity("Jack", "Bauer","timm0@285891.com"));
            employees.add(new EmployeeEntity("Hans", "O'Brian","hanssupersej@gmail.com"));
            employees.add(new EmployeeEntity("Kim", "Bauer","jimster684@forum.dk"));
            employees.add(new EmployeeEntity("David", "Palmer","Barackocama@hotmail.com"));
            employees.add(new EmployeeEntity("Michelle", "Desmynuts","agagjagijgoaf@amongus123.dk"));

            employeeRepository.saveAll(employees);

            log.info("Data has been imported wow amazing x3");
        };
    }

}
