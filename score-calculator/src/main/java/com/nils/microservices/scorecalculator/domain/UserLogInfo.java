package com.nils.microservices.scorecalculator.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Entity
public class UserLogInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date createDate;

    @Column
    private Date lastModifiedDate;

    @Column
    private BigInteger idNumber;

    @Column(length=500)
    private String latestTrxnInfo;
}
