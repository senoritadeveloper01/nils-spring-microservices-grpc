package com.nils.microservices.scorecalculator.service;

import com.nils.microservices.scorecalculator.domain.IncomeBracketMultiplierInfo;
import com.nils.microservices.scorecalculator.repository.IncomeBracketMultiplierInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class IncomeBracketMultiplierInfoService {

    private final IncomeBracketMultiplierInfoRepository incomeBracketMultiplierInfoRepository;

    public List<IncomeBracketMultiplierInfo> getIncomeBracketMultiplerInfo() {
        return incomeBracketMultiplierInfoRepository.findAll();
    }

    public Long getIncomeBracketMultiplerInfoCount() {
        return incomeBracketMultiplierInfoRepository.count();
    }

    public Optional<IncomeBracketMultiplierInfo> findById(Long id) {
        return incomeBracketMultiplierInfoRepository.findById(id);
    }
}
