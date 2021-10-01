package com.nils.microservices.cityscore.service;

import com.nils.gprc.cityscore.CityScoreRequest;
import com.nils.gprc.cityscore.CityScoreResponse;
import com.nils.gprc.cityscore.CityScoreServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class CityScoreService extends CityScoreServiceGrpc.CityScoreServiceImplBase {

    @Autowired
    private ValidationService validationService;

    @Override
    public void calculateCityScore(CityScoreRequest request, StreamObserver<CityScoreResponse> responseObserver) {
        // System.out.println("Request received from client:\n" + request);

        validationService.validateCityCode(request.getCityCode());

        Integer cityScore = request.getCityCode() * 10;

        CityScoreResponse response = CityScoreResponse.newBuilder()
                .setCityScore(cityScore)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
