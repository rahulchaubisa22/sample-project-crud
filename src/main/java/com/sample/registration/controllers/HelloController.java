package com.sample.registration.controllers;
import com.sample.registration.exception.TestException;
import com.sample.registration.model.Company;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Api(value = "company", description = "the company API")
public class HelloController {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/hello/{yourName}")
    public String sampleMethod(@PathVariable String yourName, @RequestParam Integer age) {
        return String.format("Hello, %s%nYou are %d year old", yourName, age);
    }

    @ApiOperation(value = "Test Method", nickname = "saveCompanyData", notes = "", response = Company.class, tags={ "company", })
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Company created", response = String.class),
            @ApiResponse(code = 405, message = "Missing Input", response = String.class) })
    @PostMapping("/save/detail")
    public String saveCompanyData(@RequestBody Company company) throws Exception {
        // save this company data to database --
        // introduce multi thread
        // transaction management - so no duplicate company id -
        //return String.format("This is your company, %s", company.getCompanyName());

        /**
         * by default we get below error/exception msg
         * {
         *     "timestamp": "2023-09-05T05:17:38.630+0000",
         *     "status": 500,
         *     "error": "Internal Server Error",
         *     "message": "This is sample exception",
         *     "path": "/sample-project-crud/1.0.0/save/detail"
         * }
         *
         * we want to customize it based on our need - so we will throw via CustomExceptionHandler class
         */
        //throw new TestException("This is sample exception");
        //try {
            // Make an HTTP request
            String response = restTemplate.getForObject("https://example.com/api/resource", String.class);

            // Process the successful response here
            System.out.println(response);
            //throw new Exception("testing");
//        } catch (Exception e) {
//            System.err.println("HTTP Error Status Code: " + e.getMessage());
//        } finally {
//            System.out.print("this is finally block");
//        }
        return "sample";
    }
}

