package com.se.demo.carservice.controller.api;

import com.se.demo.carservice.exception.apierror.ErrorDetail;
import com.se.demo.carservice.models.playgroud.PersonResponseItem;
import com.se.demo.carservice.models.request.PersonRequest;
import com.se.demo.carservice.models.response.PersonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "car api", description = "Operations with person")
public interface PersonApi {

    @ResponseBody
    @ApiOperation(value = "View a list of available parson ", response = PersonResponse.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list")
    })
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    List<PersonResponseItem> list();


    @ResponseBody
    @ApiOperation(value = "Search a person with an ID", response = PersonResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get an person by Id", response = PersonResponse.class),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorDetail.class),
            @ApiResponse(code = 415, message = "The has incorrect format", response = ErrorDetail.class)
    })
    PersonResponse getById(@PathVariable Long id);


    @ResponseBody
    @ApiOperation(value = "Add new person")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get an person by Id", response = PersonResponse.class),
            @ApiResponse(code = 422, message = "The value has incorrect format", response = ErrorDetail.class),
            @ApiResponse(code = 415, message = "The has incorrect format", response = ErrorDetail.class)
    })
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    PersonResponse saveProduct(@RequestBody @Valid PersonRequest personRequest);

    @ResponseBody
    @ApiOperation(value = "Update a person")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Get an person by Id", response = PersonResponse.class),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorDetail.class),
            @ApiResponse(code = 422, message = "The value has incorrect format", response = ErrorDetail.class),
            @ApiResponse(code = 415, message = "The has incorrect format", response = ErrorDetail.class)
    })
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    PersonResponse update(@PathVariable Long id, @RequestBody PersonRequest personRequest);

    @ResponseBody
    @ApiOperation(value = "Delete item")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Resource successfully deleted"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found", response = ErrorDetail.class)
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json")
    ResponseEntity delete(@PathVariable Long id);
}

