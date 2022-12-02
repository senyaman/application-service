package com.enfint.applicationservice.service.impl;

import com.enfint.applicationservice.dto.LoanApplicationRequestDTO;
import com.enfint.applicationservice.dto.LoanOfferDTO;

import java.util.List;

public interface ApplicationService {
    List<LoanOfferDTO> loanApplication(LoanApplicationRequestDTO loanApplicationRequest);
    void selectOffer(LoanOfferDTO loanOffer);
}
