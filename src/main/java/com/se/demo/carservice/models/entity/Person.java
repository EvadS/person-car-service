package com.se.demo.carservice.models.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



@Table(name = "person")
@Getter
@Setter
@Entity
@Data
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "age")
    private int age;

}
