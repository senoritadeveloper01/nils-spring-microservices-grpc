package com.nils.microservices.scorecalculator.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class IncomeBracketMultiplierInfo {

    @Id
    private Long id;

    @Column
    private String currency;

    @Column
    private Integer minThreshold;

    @Column
    private Integer maxThreshold;

    @Column
    private Integer multiplier;
}
