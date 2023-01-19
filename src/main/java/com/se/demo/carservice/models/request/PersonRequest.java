package com.se.demo.carservice.models.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Getter
@Setter
@ApiModel(description = "Provide details about the Person.")
public class PersonRequest {

    @NotEmpty(message = "first name is required field")
    @ApiModelProperty(notes = "The person first name")
    private String firstname;

    @NotEmpty(message = "last name is required field")
    @ApiModelProperty(notes = "The person first name")
    private String lastname;

    @ApiModelProperty(notes = "The person age")
    private int age;

    @ApiModelProperty(notes = "The person cars  email id")
    private Set<CarRequest> cars;
}
