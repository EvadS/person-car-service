package com.se.demo.carservice.models.request;

import com.se.demo.carservice.constraint.ValueOfCarBrand;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@ApiModel(description="Provide details about car.")
@Data
public class CarRequest {

    @ValueOfCarBrand
    @ApiModelProperty(notes = "The  brand identifier")
    private int brand;


    @NotEmpty(message = "model is required field")
    @ApiModelProperty(notes = "The car model")
    private String model;


    @ApiModelProperty(notes = "Car foundation year")
    private int foundationYear;

    @ApiModelProperty(notes = "Owner unique identifier")
    private Long personId;
}
