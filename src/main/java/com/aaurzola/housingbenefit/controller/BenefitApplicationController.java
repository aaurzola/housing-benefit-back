package com.aaurzola.housingbenefit.controller;

import com.aaurzola.housingbenefit.dto.applicationRequestDTO;
import com.aaurzola.housingbenefit.exception.ResourceNotFoundException;
import com.aaurzola.housingbenefit.model.BenefitApplication;
import com.aaurzola.housingbenefit.service.BenefitApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("benefitApplication")
public class BenefitApplicationController {

    private final BenefitApplicationService service;

    @Autowired
    public BenefitApplicationController(BenefitApplicationService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<BenefitApplication>> getAllApplications() {
        return ResponseEntity.ok(service.getAllApplications());
    }

    @GetMapping("{applicationId}")
    public ResponseEntity<BenefitApplication> getApplicationById(@PathVariable Long applicationId) {
        BenefitApplication benefitApplication = service.getBenefitApplicationById(applicationId);
        if (benefitApplication != null) {
            return ResponseEntity.status(HttpStatus.OK).body(benefitApplication);
        } else {
            throw new ResourceNotFoundException("Aplicacion", applicationId);
        }
    }

    @PostMapping()
    public ResponseEntity<BenefitApplication> submitApplication(@RequestBody applicationRequestDTO application) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.SubmitApplication(application));
    }
}
