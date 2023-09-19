package com.sample.registration.controllers;

//import com.sample.registration.annotations.SampleAnnotation;
import com.sample.registration.model.Company;
import com.sample.registration.services.RegistrationService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@RestController
@Api(value = "company", description = "the company API")
public class RegistrationController {

    @Autowired
    public RegistrationService registrationService;
    private final RestTemplate restTemplate = new RestTemplate();

    private final Bucket bucket;

    public RegistrationController() {
        Bandwidth limit = Bandwidth.classic(1, Refill.greedy(1, Duration.ofMinutes(1)));
        this.bucket = Bucket.builder()
                .addLimit(limit)
                .build();
    }

    @ApiOperation(value = "Create Company Method", nickname = "saveCompanyData", notes = "", response = Company.class, tags={ "company", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Company created", response = String.class),
            @ApiResponse(code = 405, message = "Missing Input", response = String.class) })
    @PostMapping("/company/create")
    //@SampleAnnotation
    public Company saveCompanyData(@RequestBody Company company) throws Exception {
        // call service to save data
        if (bucket.tryConsume(1)) {
            return registrationService.saveCompanyDetail(company);
        }
        return null;
    }
}

