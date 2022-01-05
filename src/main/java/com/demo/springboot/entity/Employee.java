package com.demo.springboot.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name ="employees")
public class Employee {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
