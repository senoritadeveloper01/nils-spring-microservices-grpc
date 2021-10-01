package com.nils.microservices.cityscore.exception;

import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.nils.gprc.cityscore.CityScoreExceptionResponse;
import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import net.devh.boot.grpc.server.advice.GrpcAdvice;
import net.devh.boot.grpc.server.advice.GrpcExceptionHandler;

import java.time.Instant;

@GrpcAdvice
public class CityScoreExceptionHandler {

    @GrpcExceptionHandler(CityScoreException.class)
    public StatusRuntimeException handleValidationError(CityScoreException cause) {

        Instant time = Instant.now();
        Timestamp timestamp = Timestamp.newBuilder().setSeconds(time.getEpochSecond())
                .setNanos(time.getNano()).build();

        CityScoreExceptionResponse exceptionResponse =
                CityScoreExceptionResponse.newBuilder()
                        .setErrorCode(cause.getErrorCode())
                        .setTimestamp(timestamp)
                        .build();


        Status status = Status.newBuilder()
                        .setCode(Code.INVALID_ARGUMENT.getNumber())
                        .setMessage("Invalid city code")
                        .addDetails(Any.pack(exceptionResponse))
                        .build();

        return StatusProto.toStatusRuntimeException(status);
    }
}
