package com.nils.microservices.scorecalculator.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ScoreCalculatorErrorCode {

    INVALID_INCOME_BRACKET_MULTIPLIER_ID("Income bracket multiplier record cannot be found for id value: %d");

    private final String message;

}
