package com.sample.registration.controllers;

import com.sample.registration.annotations.SampleAnnotation;
import com.sample.registration.model.Company;
import com.sample.registration.services.RegistrationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(value = "company", description = "the company API")
public class RegistrationController {

    @Autowired
    public RegistrationService registrationService;
    private final RestTemplate restTemplate = new RestTemplate();


    @ApiOperation(value = "Create Company Method", nickname = "saveCompanyData", notes = "", response = Company.class, tags={ "company", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Company created", response = String.class),
            @ApiResponse(code = 405, message = "Missing Input", response = String.class) })
    @PostMapping("/company/create")
    @SampleAnnotation
    public Company saveCompanyData(@RequestBody Company company) throws Exception {
        // call service to save data

        return registrationService.saveCompanyDetail(company);
    }
}

