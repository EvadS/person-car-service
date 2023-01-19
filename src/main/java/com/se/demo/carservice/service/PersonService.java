package com.se.demo.carservice.service;

import com.se.demo.carservice.models.playgroud.PersonResponseItem;
import com.se.demo.carservice.models.request.PersonRequest;
import com.se.demo.carservice.models.response.PersonResponse;

import java.util.List;

public interface PersonService {
    List<PersonResponseItem> getAllPerson();

    PersonResponse getById(Long id);

    PersonResponse save(PersonRequest personRequest);

    PersonResponse update(Long id, PersonRequest personRequest);

    void delete(Long id);
}
