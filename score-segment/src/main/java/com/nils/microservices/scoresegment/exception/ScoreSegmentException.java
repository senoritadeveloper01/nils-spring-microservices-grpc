package com.nils.microservices.scoresegment.exception;

import com.nils.gprc.scoresegment.ScoreSegmentErrorCode;
import lombok.Getter;

@Getter
public class ScoreSegmentException extends RuntimeException {

    // TODO: NilS
    private static final long serialVersionUID = -8111656859346000121L;

    private ScoreSegmentErrorCode errorCode;

    public ScoreSegmentException(ScoreSegmentErrorCode errorCode) {
        super(errorCode.name());
        this.errorCode = errorCode;
    }
}
