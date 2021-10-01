package com.nils.microservices.scorecalculator.model.validation.validator;

import com.nils.microservices.scorecalculator.model.validation.annotation.ValidName;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class NameValidator implements ConstraintValidator<ValidName, String> {

    @Value("${request.name.regex.pattern}")
    private String nameRegexPattern;

    private Pattern pattern;

    @Override
    public void initialize(ValidName constraintAnnotation) {
        pattern = Pattern.compile(nameRegexPattern);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return pattern.matcher(value).matches();
    }
}
