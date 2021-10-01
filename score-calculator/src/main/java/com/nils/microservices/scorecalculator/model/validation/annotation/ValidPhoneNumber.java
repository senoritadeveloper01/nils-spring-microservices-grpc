package com.nils.microservices.scorecalculator.model.validation.annotation;

import com.nils.microservices.scorecalculator.model.validation.ScoreCalculatorRequestValidationConstants;
import com.nils.microservices.scorecalculator.model.validation.validator.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneNumberValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {
    String message() default ScoreCalculatorRequestValidationConstants.INVALID_PHONE_NUMBER;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
