package com.nils.microservices.scorecalculator.service;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.UInt64Value;
import com.google.rpc.ErrorInfo;
import com.google.rpc.Status;
import com.nils.gprc.cityscore.CityScoreExceptionResponse;
import com.nils.gprc.cityscore.CityScoreRequest;
import com.nils.gprc.cityscore.CityScoreResponse;
import com.nils.gprc.cityscore.CityScoreServiceGrpc;
import com.nils.gprc.scoresegment.ScoreSegmentExceptionResponse;
import com.nils.gprc.scoresegment.ScoreSegmentRequest;
import com.nils.gprc.scoresegment.ScoreSegmentResponse;
import com.nils.gprc.scoresegment.ScoreSegmentServiceGrpc;
import com.nils.microservices.scorecalculator.domain.IncomeBracketMultiplierInfo;
import com.nils.microservices.scorecalculator.exception.ScoreCalculatorException;
import com.nils.microservices.scorecalculator.model.ScoreCalculatorErrorCode;
import com.nils.microservices.scorecalculator.model.ScoreCalculatorRequest;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class ScoreCalculatorService {

    @GrpcClient("city-score")
    private CityScoreServiceGrpc.CityScoreServiceBlockingStub cityScoreStub;

    @GrpcClient("score-segment")
    private ScoreSegmentServiceGrpc.ScoreSegmentServiceBlockingStub scoreSegmentStub;

    @Autowired
    private IncomeBracketMultiplierInfoService incomeBracketMultiplierInfoService;


    public BigInteger calculateScore(ScoreCalculatorRequest scoreCalculatorRequest) {
        IncomeBracketMultiplierInfo selectedIncomeBracketMultiplerInfo = getIncomeBracketMultiplerInfo(scoreCalculatorRequest.getIncomeBracketMultiplierId());

        BigInteger scoreSegment = getScoreSegment(scoreCalculatorRequest.getIdNumber());
        Integer cityScore = getCityScore(scoreCalculatorRequest.getCityCode());
        BigInteger score = BigInteger.valueOf(selectedIncomeBracketMultiplerInfo.getMultiplier().intValue())
                                    .multiply(scoreSegment)
                                    .add(BigInteger.valueOf(cityScore.intValue()));

        return score;
    }

    private BigInteger getScoreSegment(BigInteger idNumber) {
        ScoreSegmentRequest scoreSegmentRequest = ScoreSegmentRequest.newBuilder()
                                                                    .setIdNumber(UInt64Value.newBuilder().setValue(idNumber.longValue()).build())
                                                                    .build();
        try {
            ScoreSegmentResponse scoreSegmentResponse = scoreSegmentStub.calculateScoreSegment(scoreSegmentRequest);
            return new BigInteger(scoreSegmentResponse.getScoreSegment().toString());
        } catch (Exception e){
            Status status = StatusProto.fromThrowable(e);
            for (Any any : status.getDetailsList()) {
                if (!any.is(ScoreSegmentExceptionResponse.class)) {
                    continue;
                }
                try {
                    ScoreSegmentExceptionResponse exceptionResponse = any.unpack(ScoreSegmentExceptionResponse.class);
                    System.out.println("timestamp: " + exceptionResponse.getTimestamp() +
                            ", errorCode : " + exceptionResponse.getErrorCode());
                } catch (InvalidProtocolBufferException ex) {
                    ex.printStackTrace();
                }
            }
            // System.out.println(status.getCode() + " : " + status.getDescription());
        }

        // return a default value
        return BigInteger.ONE;
    }

    private Integer getCityScore(Integer cityCode) {
        CityScoreRequest cityScoreRequest = CityScoreRequest.newBuilder()
                                                            .setCityCode(cityCode)
                                                            .build();
        try {
            CityScoreResponse cityScoreResponse = cityScoreStub.calculateCityScore(cityScoreRequest);
            return cityScoreResponse.getCityScore();
        } catch (StatusRuntimeException e){
            Status status = StatusProto.fromThrowable(e);
            for (Any any : status.getDetailsList()) {
                if (!any.is(CityScoreExceptionResponse.class)) {
                    continue;
                }
                try {
                    CityScoreExceptionResponse exceptionResponse = any.unpack(CityScoreExceptionResponse.class);
                    System.out.println("timestamp: " + exceptionResponse.getTimestamp() +
                            ", errorCode : " + exceptionResponse.getErrorCode());
                } catch (InvalidProtocolBufferException ex) {
                    ex.printStackTrace();
                }
            }
            // System.out.println(status.getCode() + " : " + status.getDescription());
        }

        // return a default value
        return Integer.valueOf(1);
    }

    private IncomeBracketMultiplierInfo getIncomeBracketMultiplerInfo(Long incomeBracketMultiplerInfoId) {
        Optional<IncomeBracketMultiplierInfo> multiplierInfo = incomeBracketMultiplierInfoService.findById(incomeBracketMultiplerInfoId);
        if (!multiplierInfo.isPresent()) {
            throw new ScoreCalculatorException(ScoreCalculatorErrorCode.INVALID_INCOME_BRACKET_MULTIPLIER_ID, incomeBracketMultiplerInfoId);
        }
        return multiplierInfo.get();
    }
}
