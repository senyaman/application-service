package com.enfint.applicationservice.service.impl;

import com.enfint.applicationservice.dto.LoanApplicationRequestDTO;
import com.enfint.applicationservice.dto.LoanOfferDTO;
import com.enfint.applicationservice.feignclient.DealClient;
import com.enfint.applicationservice.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationServiceImpl implements ApplicationService {

    private final DealClient dealClient;

    @Override
    public List<LoanOfferDTO> loanApplication(LoanApplicationRequestDTO loanApplicationRequest) {
        ResponseEntity<List<LoanOfferDTO>> dealResponseEntity = dealClient.loanApplication(loanApplicationRequest);
        return dealResponseEntity.getBody();
    }

    @Override
    public void selectOffer(LoanOfferDTO loanOffer) {
        log.info("***********selecting loan offer*********");
        dealClient.updateOffer(loanOffer);
    }
}
