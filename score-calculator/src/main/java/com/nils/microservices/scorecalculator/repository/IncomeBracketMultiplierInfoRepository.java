package com.nils.microservices.scorecalculator.repository;

import com.nils.microservices.scorecalculator.domain.IncomeBracketMultiplierInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeBracketMultiplierInfoRepository extends JpaRepository<IncomeBracketMultiplierInfo, Long> {

}
