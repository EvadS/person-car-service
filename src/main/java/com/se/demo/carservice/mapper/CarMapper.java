package com.se.demo.carservice.mapper;


import com.se.demo.carservice.models.entity.Car;
import com.se.demo.carservice.models.request.CarRequest;
import com.se.demo.carservice.models.response.CarResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);


    @Mappings({
            @Mapping(source = "brand", target = "brand"),
            @Mapping(source = "model", target = "model"),
            @Mapping(source = "foundationYear", target = "foundationYear")
    })
    Car toCar(CarRequest carRequest);


    @Mappings({
            @Mapping(target = "id", source = "id"),
            @Mapping(target = "carRequest.brand", source = "brand"),
            @Mapping(target = "carRequest.model", source = "model"),
            @Mapping(target = "carRequest.foundationYear", source = "foundationYear")
    })
    CarResponse toCarResponse(Car car);
}


