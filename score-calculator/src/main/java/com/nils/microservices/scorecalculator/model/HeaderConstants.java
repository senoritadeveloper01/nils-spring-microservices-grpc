package com.nils.microservices.scorecalculator.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HeaderConstants {

    X_TOTAL_COUNT("X-Total-Count");

    private String value;

}
