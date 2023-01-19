package com.se.demo.carservice.controller.api;


import com.se.demo.carservice.exception.apierror.ErrorDetail;
import com.se.demo.carservice.models.request.CarRequest;
import com.se.demo.carservice.models.response.CarResponse;
import com.se.demo.carservice.models.response.PersonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value="car api", description="Operations with car")
public interface CarApi {


    @ApiOperation(value = "View a list of available employees",response = CarResponse.class,  responseContainer = "List")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list")
    })
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    List<CarResponse> list();


    @ApiOperation(value = "Search a car with an ID", response =CarResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get an person by Id", response = PersonResponse.class),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorDetail.class),
            @ApiResponse(code = 415, message = "The has incorrect format", response = ErrorDetail.class)
    })
    @RequestMapping(value = "/{id}", method= RequestMethod.GET, produces = "application/json")
    CarResponse getById(@PathVariable Long id);

    @ApiOperation(value = "Add new car")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get an person by Id", response = PersonResponse.class),
            @ApiResponse(code = 422, message = "The value has incorrect format", response = ErrorDetail.class),
            @ApiResponse(code = 415, message = "The has incorrect format", response = ErrorDetail.class)
    })
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    CarResponse saveProduct(@RequestBody @Valid CarRequest carRequest);

    @ApiOperation(value = "Update a car")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get an person by Id", response = PersonResponse.class),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorDetail.class),
            @ApiResponse(code = 422, message = "The value has incorrect format", response = ErrorDetail.class),
            @ApiResponse(code = 415, message = "The has incorrect format", response = ErrorDetail.class)
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    CarResponse update(@PathVariable Long id, @RequestBody CarRequest carRequest);


    @ApiOperation(value = "Delete a car")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Resource successfully deleted"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorDetail.class)
    })
    @RequestMapping(value="/{id}", method = RequestMethod.DELETE, produces = "application/json")
    ResponseEntity delete(@PathVariable Long id);

}