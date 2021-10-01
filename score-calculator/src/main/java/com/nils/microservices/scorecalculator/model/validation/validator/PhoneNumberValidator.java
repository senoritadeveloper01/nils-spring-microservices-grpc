package com.nils.microservices.scorecalculator.model.validation.validator;

import com.nils.microservices.scorecalculator.model.validation.annotation.ValidPhoneNumber;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    @Value("${request.phone-number.regex.pattern}")
    private String phoneNumberPattern;

    private Pattern pattern;

    @Override
    public void initialize(ValidPhoneNumber constraintAnnotation) {
        pattern = Pattern.compile(phoneNumberPattern);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // com.google.i18n.phonenumbers.PhoneNumberUtil lib could be used instead
        return pattern.matcher(value).matches();
    }
}
