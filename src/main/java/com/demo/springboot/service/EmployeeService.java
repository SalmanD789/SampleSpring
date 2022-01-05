package com.demo.springboot.service;

import com.demo.springboot.entity.Employee;
import com.demo.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private  EmployeeRepository repository;


    public List<Employee> getEmployees(){
        return  repository.findAll();
    }

    //Adding Employee
    public String addEmployee(Employee employee){
        if(employee.getEmailId()!=null && employee.getEmailId().contains("@")){
            repository.save(employee);
            return "Employee Created";
        }
        else
            throw new IllegalArgumentException("Email Id not entered or entered Wrong Email Id");
    }


    //Deleting Employee
    public String deleteEmployee(long id){
        Optional<Employee> temp= repository.findById(id);
        if (temp.isPresent()){
            repository.deleteById(id);
            return "EMPLOYEE DELETED";
        }
        else
            throw new NoSuchElementException("No Employee Found to Deleted");
    }

    //Get Employee by id
    public Employee getEmployee(Long id){
        Optional<Employee> temp=repository.findById(id);
        if(temp.isPresent())
            return repository.findById(id).get();
        else
            throw new NoSuchElementException("EMPLOYEE IS NOT FOUND");
    }

    //update
    public String updateEmployee(Employee employee,Long id){
        Optional<Employee> temp=repository.findById(id);
        if(temp.isPresent()){
            Employee e=repository.getById(id);
            String s="";
            if(!e.getFirstName().equals(employee.getFirstName())){
                e.setFirstName(employee.getFirstName());
                repository.save(e);
                s="Updated First Name.\n";
            }
            if(!e.getLastName().equals(employee.getLastName())){
                e.setLastName(employee.getLastName());
                repository.save(e);
                s="Updated Last Name.\n";
            }
            if(!e.getEmailId().equals(employee.getEmailId())){
                e.setEmailId(employee.getEmailId());
                repository.save(e);
                s="Updated Email.";
            }
            return s;
        }
        else
            throw new NoSuchElementException("NO Employee Found Here");
    }


}
