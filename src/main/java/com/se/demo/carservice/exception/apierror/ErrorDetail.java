package com.se.demo.carservice.exception.apierror;


import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "Error Detail response")
@NoArgsConstructor
public class ErrorDetail {

    @ApiModelProperty( name = "Error Detail Title", required = true, example = "Resource not found")
    private String message;

    @ApiModelProperty(name = "Error Detail Description", required = true, example = "Requested resource cannot be found")
    private String detail;

    @ApiModelProperty(name = "HTTP Status Code", example = "404")
    private Integer status;

    @ApiModelProperty(name = "List of additional errors")
    private List<ApiValidationError> errors;

    private String stackTrace;

    public ErrorDetail(final String title, final String detail) {
        this.message = title;
        this.detail = detail;
    }
}
