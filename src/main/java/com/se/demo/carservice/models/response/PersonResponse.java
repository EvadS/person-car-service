package com.se.demo.carservice.models.response;

import com.se.demo.carservice.models.request.PersonRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PersonResponse {
    @ApiModelProperty(notes = "Unique identifier")
    private Long id;

    @ApiModelProperty(notes = "Person request")
    private PersonRequest personRequest;
}
