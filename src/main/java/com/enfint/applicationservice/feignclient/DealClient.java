package com.enfint.applicationservice.feignclient;

import com.enfint.applicationservice.dto.LoanApplicationRequestDTO;
import com.enfint.applicationservice.dto.LoanOfferDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "deal-service", url = "http://localhost:8081/deal")
public interface DealClient {

    @PostMapping("/application")
    ResponseEntity<List<LoanOfferDTO>> loanApplication(@Valid @RequestBody LoanApplicationRequestDTO loanApplicationRequest);

    @PutMapping("/offer")
    void updateOffer(@RequestBody LoanOfferDTO loanOffer);
}
