package com.se.demo.carservice.service;

import com.se.demo.carservice.models.request.CarRequest;
import com.se.demo.carservice.models.response.CarResponse;

import java.util.List;

public interface CarService {
    List<CarResponse> getAll();

    CarResponse getById(Long id);

    CarResponse save(CarRequest carRequest);

    CarResponse update(Long id, CarRequest carRequest);

    void delete(Long id);
}
