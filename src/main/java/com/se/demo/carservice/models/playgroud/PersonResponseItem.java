package com.se.demo.carservice.models.playgroud;

import com.se.demo.carservice.models.entity.Car;
import com.se.demo.carservice.models.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonResponseItem {
    private Person person;
    private List<Car> cars;

}
