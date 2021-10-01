package com.nils.microservices.scorecalculator.model.validation.annotation;

import com.nils.microservices.scorecalculator.model.validation.ScoreCalculatorRequestValidationConstants;
import com.nils.microservices.scorecalculator.model.validation.validator.CityCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CityCodeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidName {
    String message() default ScoreCalculatorRequestValidationConstants.INVALID_NAME_OR_SURNAME;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
