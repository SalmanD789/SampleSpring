package com.demo.springboot.controller;


import com.demo.springboot.entity.Employee;
import com.demo.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;


    //Add One Emp
    @PostMapping("/addEmployee")
    public  String  addEmployee(@RequestBody Employee employee){

        return service.addEmployee(employee);
    }
    //Get All Employees
    @GetMapping("/Employees")
    public List<Employee> getEmployees(){

        return service.getEmployees();
    }

    //Get By Emp ID
    @GetMapping("/Employee/{id}")
    public Employee getEmployeeById(@PathVariable long id){

        return service.getEmployee(id);
    }


    //Update
    @PutMapping("/update/{id}")
    public String updateEmployee(@RequestBody Employee employee,@PathVariable long id){
        return service.updateEmployee(employee,id);
    }

    //Delete
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable long id) {
        return service.deleteEmployee(id);
    }


}
