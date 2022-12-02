package com.enfint.applicationservice.controller;

import com.enfint.applicationservice.dto.LoanApplicationRequestDTO;
import com.enfint.applicationservice.dto.LoanOfferDTO;
import com.enfint.applicationservice.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    ResponseEntity<List<LoanOfferDTO>> loanApplication(@Valid @RequestBody LoanApplicationRequestDTO loanApplicationRequest) {
        List<LoanOfferDTO> loanOffers = applicationService.loanApplication(loanApplicationRequest);
        return ResponseEntity.ok(loanOffers);
    }

    @PutMapping("/offer")
    void updateOffer(@RequestBody LoanOfferDTO loanOffer) {
        applicationService.selectOffer(loanOffer);
    }
}
