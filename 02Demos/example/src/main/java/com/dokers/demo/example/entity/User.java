package com.dokers.demo.example.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Data
@Document(indexName = "user")
public class User {
    @Id
    @Field(type = FieldType.Text)
    private String id;
    @Field(store = true)
    private String username;
    @Field(store = true)
    private String address;
    @Field(store = true)
    private String email;
    @Field(type = FieldType.Date, store = true)
    private Date birthday;
}
