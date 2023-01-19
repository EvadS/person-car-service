package com.se.demo.carservice.repository;


import com.se.demo.carservice.models.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findAllByPersonId(Long personId);
}
