package com.nils.microservices.scorecalculator.model;

import com.nils.microservices.scorecalculator.model.validation.ScoreCalculatorRequestValidationConstants;

import com.nils.microservices.scorecalculator.model.validation.annotation.ValidCityCode;
import com.nils.microservices.scorecalculator.model.validation.annotation.ValidIdNumber;
import com.nils.microservices.scorecalculator.model.validation.annotation.ValidName;
import com.nils.microservices.scorecalculator.model.validation.annotation.ValidPhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScoreCalculatorRequest {

    @ValidIdNumber
    private BigInteger idNumber;

    @ValidName
    private String name;

    @ValidName
    private String surname;

    @ValidPhoneNumber
    private String phoneNumber;

    @ValidCityCode
    private Integer cityCode;

    @NotNull(message = ScoreCalculatorRequestValidationConstants.INCOME_BRACKET_MULTIPLIER_ID_CANNOT_BE_NULL)
    @Min(value = 1, message = ScoreCalculatorRequestValidationConstants.INVALID_INCOME_BRACKET_MULTIPLIER_ID)
    private Long incomeBracketMultiplierId;
}
