package com.nils.microservices.cityscore.service;

import com.nils.gprc.cityscore.CityScoreErrorCode;
import com.nils.microservices.cityscore.exception.CityScoreException;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public void validateCityCode(Integer cityCode) {
        checkIfNull(cityCode);
        checkIfValid(cityCode);
    }

    private void checkIfNull(Integer cityCode) {
        if (cityCode == null) {
            throw new CityScoreException(CityScoreErrorCode.CITY_CODE_CANNOT_BE_NULL);
        }
    }

    private void checkIfValid(Integer cityCode) {
       if(cityCode < 1 || cityCode > 81) {
           throw new CityScoreException(CityScoreErrorCode.INVALID_CITY_CODE_VALUE);
       }
    }
}
