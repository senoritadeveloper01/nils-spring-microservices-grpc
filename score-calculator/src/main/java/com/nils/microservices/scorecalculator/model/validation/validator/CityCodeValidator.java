package com.nils.microservices.scorecalculator.model.validation.validator;

import com.nils.microservices.scorecalculator.model.validation.annotation.ValidCityCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CityCodeValidator implements ConstraintValidator<ValidCityCode, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value < 1 || value > 81) {
            return false;
        }
        return true;
    }
}
