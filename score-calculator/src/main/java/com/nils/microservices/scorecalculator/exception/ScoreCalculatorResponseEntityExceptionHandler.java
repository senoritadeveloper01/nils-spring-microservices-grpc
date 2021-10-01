package com.nils.microservices.scorecalculator.exception;

import com.nils.microservices.scorecalculator.model.validation.ScoreCalculatorRequestValidationConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.Date;

@ControllerAdvice
@RestController // because it is providing a response back
public class ScoreCalculatorResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentTypeMismatchException.class, ScoreCalculatorException.class})
    public final ResponseEntity<Object> handleValidationExceptions(Exception ex, WebRequest request) {
        ScoreCalculatorExceptionResponse exceptionResponse =
                new ScoreCalculatorExceptionResponse(new Date(), ScoreCalculatorRequestValidationConstants.INVALID_PARAMETER_TYPE,
                        ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}