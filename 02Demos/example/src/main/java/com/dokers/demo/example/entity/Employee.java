package com.dokers.demo.example.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Data
@Document(indexName = "employee")
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String about;
    private List<String> interests;
}
