package com.nils.microservices.scoresegment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScoreSegmentResponse {

    private BigInteger scoreSegment;

    private String environment;
}
