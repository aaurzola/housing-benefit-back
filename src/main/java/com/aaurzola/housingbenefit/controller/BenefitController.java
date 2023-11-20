package com.aaurzola.housingbenefit.controller;

import com.aaurzola.housingbenefit.model.Benefit;
import com.aaurzola.housingbenefit.service.benefit.BenefitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "benefitDetails")
public class BenefitController {

    private final BenefitService benefitService;

    @Autowired
    public BenefitController(BenefitService benefitService) {
        this.benefitService = benefitService;
    }

    @GetMapping("{requestId}")
    public ResponseEntity<List<Benefit>> getBenefitDetails(@PathVariable Long requestId) {
        return ResponseEntity.ok().body(benefitService.findBenefitDetails(requestId));
    }
}
