package com.nils.microservices.scorecalculator.model.validation.validator;

import com.nils.microservices.scorecalculator.model.validation.annotation.ValidIdNumber;
import com.nils.microservices.scorecalculator.utils.IdNumberUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigInteger;

public class IdNumberValidator implements ConstraintValidator<ValidIdNumber, BigInteger> {

    @Override
    public boolean isValid(BigInteger value, ConstraintValidatorContext context) {
        if (value == null && !IdNumberUtils.isValid(value.toString())) {
            return false;
        }
        return true;
    }
}
