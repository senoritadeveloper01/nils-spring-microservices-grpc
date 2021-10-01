package com.nils.microservices.cityscore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CityScoreResponse {

    private Integer cityScore;

    private String environment;

}
