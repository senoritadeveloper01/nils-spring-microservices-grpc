package com.nils.microservices.scorecalculator.exception;

import com.nils.microservices.scorecalculator.model.ScoreCalculatorErrorCode;
import lombok.Getter;

@Getter
public class ScoreCalculatorException extends RuntimeException {

    // TODO: NilS
    private static final long serialVersionUID = -8111656859346000121L;

    private ScoreCalculatorErrorCode errorCode;

    public ScoreCalculatorException(ScoreCalculatorErrorCode errorCode, Object... args) {
        this(errorCode, null, args);
    }

    public ScoreCalculatorException(ScoreCalculatorErrorCode errorCode, Throwable cause, Object... args) {
        super(errorCode.name() + " - " + String.format(errorCode.getMessage(), args), cause);
        this.errorCode = errorCode;
    }
}