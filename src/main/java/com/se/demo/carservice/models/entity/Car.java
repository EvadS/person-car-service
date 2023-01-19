package com.se.demo.carservice.models.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
@Table(name = "car")
@Getter
@Setter
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "brand")
    private int brand;

    @Column(name = "model")
    private String model;

    @Column(name = "foundationYear")
    private int foundationYear;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = true)
    private Person person;
}
