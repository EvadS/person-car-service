package com.se.demo.carservice.models.response;

import com.se.demo.carservice.models.request.CarRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarResponse {

    @ApiModelProperty(notes = "Car unique identifier")
    private Long id;


    @ApiModelProperty(notes = "The car request")
    private CarRequest carRequest;
}
