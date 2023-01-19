package com.se.demo.carservice.service.impl;


import com.se.demo.carservice.exception.model.ResourceNotFoundException;
import com.se.demo.carservice.mapper.CarMapper;
import com.se.demo.carservice.mapper.PersonMapper;
import com.se.demo.carservice.models.entity.Car;
import com.se.demo.carservice.models.entity.Person;
import com.se.demo.carservice.models.playgroud.PersonResponseItem;
import com.se.demo.carservice.models.request.CarRequest;
import com.se.demo.carservice.models.request.PersonRequest;
import com.se.demo.carservice.models.response.PersonResponse;
import com.se.demo.carservice.repository.CarRepository;
import com.se.demo.carservice.repository.PersonRepository;
import com.se.demo.carservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final CarRepository carRepository;


    @Override
    public List<PersonResponseItem> getAllPerson() {
        List<PersonResponseItem> personsList = new ArrayList<>();
        personRepository.findAll().stream().forEach(i -> {
            List<Car> allByPerson = carRepository.findAllByPersonId(i.getId());
            personsList.add(new PersonResponseItem(i, allByPerson));
        });

        return personsList;
    }

    @Override
    public PersonResponse getById(Long id) {
        log.info("Get person by id:{}", id);
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));

        return PersonMapper.INSTANCE.toPersonResponse(person);
    }

    @Override
    public PersonResponse save(PersonRequest personRequest) {
        log.info("Create new person {}", personRequest);

        Person person = PersonMapper.INSTANCE.toPerson(personRequest);
        personRepository.save(person);

        for (CarRequest item : personRequest.getCars()) {
            Car car = CarMapper.INSTANCE.toCar(item);
            car.setPerson(person);
            carRepository.save(car);
        }

        log.info("Created new person, id:{}", person.getId());
        return PersonMapper.INSTANCE.toPersonResponse(person);
    }

    @Override
    public PersonResponse update(Long id, PersonRequest personRequest) {
        log.info("Update person, id:{}", id);
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));

        person.setAge(personRequest.getAge());
        person.setFirstName(personRequest.getFirstname());
        person.setLastName(person.getLastName());


        personRepository.save(person);

        log.info("person, id:{}, updated", id);
        return PersonMapper.INSTANCE.toPersonResponse(person);
    }

    @Override
    public void delete(Long id) {
        log.info("person, id:{}, deleted", id);
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person", "id", id));

        personRepository.delete(person);
    }
}
