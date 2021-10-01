package com.nils.microservices.scorecalculator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nils.microservices.scorecalculator.domain.UserLogInfo;
import com.nils.microservices.scorecalculator.model.ScoreCalculatorRequest;
import com.nils.microservices.scorecalculator.repository.UserLogInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserLogInfoService {

    private final ObjectMapper objectMapper;

    private final UserLogInfoRepository userLogInfoRepository;

    public void saveUserLog(ScoreCalculatorRequest scoreCalculatorRequest) {
        try {
            UserLogInfo logInfo = new UserLogInfo();
            logInfo.setIdNumber(scoreCalculatorRequest.getIdNumber());
            logInfo.setLatestTrxnInfo(objectMapper.writeValueAsString(scoreCalculatorRequest));
            this.saveOrUpdate(logInfo);
        } catch (Exception e) {
            // TODO: NilS
            log.error("Unexpected error");
        }
    }

    private UserLogInfo saveOrUpdate(UserLogInfo logInfo) {
        UserLogInfo currentLogInfo  = this.findByIdNumber(logInfo.getIdNumber());
        if (currentLogInfo == null) {
            logInfo.setCreateDate(new Date());
            logInfo.setLastModifiedDate(new Date());
            userLogInfoRepository.save(logInfo);
            return logInfo;
        } else {
            currentLogInfo.setLatestTrxnInfo(logInfo.getLatestTrxnInfo());
            currentLogInfo.setLastModifiedDate(new Date());
            userLogInfoRepository.save(currentLogInfo);
            return currentLogInfo;
        }
    }

    private UserLogInfo findByIdNumber(BigInteger idNumber) {
        return userLogInfoRepository.findByIdNumber(idNumber);
    }

    private UserLogInfo save(UserLogInfo logInfo) {
        return userLogInfoRepository.save(logInfo);
    }
}
