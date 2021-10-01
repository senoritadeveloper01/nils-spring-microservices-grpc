package com.nils.microservices.scorecalculator.model.proxy;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ScoreSegmentResponse {

    private BigInteger scoreSegment;
}
