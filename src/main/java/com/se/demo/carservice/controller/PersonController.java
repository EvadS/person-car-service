package com.se.demo.carservice.controller;

import com.se.demo.carservice.controller.api.PersonApi;
import com.se.demo.carservice.models.playgroud.PersonResponseItem;
import com.se.demo.carservice.models.request.PersonRequest;
import com.se.demo.carservice.models.response.PersonResponse;
import com.se.demo.carservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController  implements PersonApi {
    private final PersonService personService;

    @Override
    public List<PersonResponseItem> list() {
        return personService.getAllPerson();
    }

    @Override
    public PersonResponse getById(Long id) {

        return personService.getById(id);
    }

    @Override
    public PersonResponse saveProduct(@Valid PersonRequest personRequest) {
        return personService.save(personRequest);
    }

    @Override
    public PersonResponse update(Long id, PersonRequest personRequest) {
        return personService.update(id, personRequest);
    }

    @Override
    public ResponseEntity delete(Long id) {
        personService.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
