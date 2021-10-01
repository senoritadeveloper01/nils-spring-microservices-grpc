package com.nils.microservices.cityscore.exception;

import com.nils.gprc.cityscore.CityScoreErrorCode;
import lombok.Getter;

@Getter
public class CityScoreException extends RuntimeException {

    // TODO: NilS
    private static final long serialVersionUID = -8111656859346000121L;

    private CityScoreErrorCode errorCode;

    public CityScoreException(CityScoreErrorCode errorCode) {
        super(errorCode.name());
        this.errorCode = errorCode;
    }
}