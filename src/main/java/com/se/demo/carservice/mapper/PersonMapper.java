package com.se.demo.carservice.mapper;

import com.se.demo.carservice.models.entity.Person;
import com.se.demo.carservice.models.request.PersonRequest;
import com.se.demo.carservice.models.response.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mappings({
            @Mapping(source = "firstname", target = "firstName"),
            @Mapping(source = "lastname", target = "lastName"),
            @Mapping(source = "age", target = "age")
    })
    Person toPerson(PersonRequest personRequest);


    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "personRequest.firstname", source = "firstName"),
            @Mapping(target = "personRequest.lastname", source = "firstName"),
            @Mapping(target = "personRequest.age", source = "age")
    })
    PersonResponse toPersonResponse(Person person);
}
