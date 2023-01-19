package com.se.demo.carservice.service.impl;

import com.se.demo.carservice.exception.model.ResourceNotFoundException;
import com.se.demo.carservice.mapper.CarMapper;
import com.se.demo.carservice.models.entity.Car;
import com.se.demo.carservice.models.entity.Person;
import com.se.demo.carservice.models.enums.CarBrand;
import com.se.demo.carservice.models.request.CarRequest;
import com.se.demo.carservice.models.response.CarResponse;
import com.se.demo.carservice.repository.CarRepository;
import com.se.demo.carservice.repository.PersonRepository;
import com.se.demo.carservice.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final PersonRepository personRepository;

    @Override
    public List<CarResponse> getAll() {

        return carRepository.findAll().stream()
                .map(CarMapper.INSTANCE::toCarResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CarResponse getById(Long id) {
        log.info("Get car {}", id);
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cars", "id", id));

        return CarMapper.INSTANCE.toCarResponse(car);
    }

    @Override
    public CarResponse save(CarRequest carRequest) {
        log.info("Create new car {}", carRequest);

        Car car = CarMapper.INSTANCE.toCar(carRequest);
        carRepository.save(car);

        log.info("Created new car: {}", car.toString());
        return CarMapper.INSTANCE.toCarResponse(car);

    }

    @Override
    public CarResponse update(Long id, CarRequest carRequest) {
        log.info("Update person, id:{}", id);
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));

        Person person = personRepository.findById(carRequest.getPersonId())
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));

        CarBrand carBrand = CarBrand.of(carRequest.getBrand());
        car.setBrand(carBrand.getId());

        car.setFoundationYear(car.getFoundationYear());
        car.setModel(car.getModel());
        car.setPerson(person);

        carRepository.save(car);

        log.info("car, id:{}, updated", id);
        return CarMapper.INSTANCE.toCarResponse(car);
    }

    @Override
    public void delete(Long id) {

        Car car = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", id));

        carRepository.delete(car);
        log.info("car, id:{}, deleted", id);
    }
}
