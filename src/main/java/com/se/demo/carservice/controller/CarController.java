package com.se.demo.carservice.controller;

import com.se.demo.carservice.controller.api.CarApi;
import com.se.demo.carservice.models.request.CarRequest;
import com.se.demo.carservice.models.response.CarResponse;
import com.se.demo.carservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarController implements CarApi {


    private final CarService carService;

    @Override
    public List<CarResponse> list() {
        return carService.getAll();
    }

    @Override
    public CarResponse getById(Long id) {
        return carService.getById(id);
    }

    @Override
    public CarResponse saveProduct(@Valid @RequestBody CarRequest carRequest) {
        return carService.save(carRequest);
    }

    @Override
    public CarResponse update(Long id,@Valid @RequestBody  CarRequest carRequest) {
        return carService.update(id, carRequest);
    }

    @Override
    public ResponseEntity delete(Long id) {
        carService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
