package com.se.demo.carservice.constraint.impl;

import com.se.demo.carservice.constraint.ValueOfCarBrand;
import com.se.demo.carservice.models.enums.CarBrand;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CarBrandCarBrandValidator implements ConstraintValidator<ValueOfCarBrand, Integer> {
    public void initialize(ValueOfCarBrand constraint) {
    }

    @Override
    public boolean isValid(Integer obj, ConstraintValidatorContext context) {
        CarBrand carBrand = CarBrand.of(obj);

        // TODO: good practice to use default value
        if (carBrand == null)/*CarBrand.NOT_SET)*/
            return false;

        return true;
    }
}