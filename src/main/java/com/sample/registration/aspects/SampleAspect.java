package com.sample.registration.aspects;
import com.sample.registration.model.Company;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;

@Aspect
@Component
public class SampleAspect {

    @Before("execution(* com.sample.registration.controllers.RegistrationController.*(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void beforeControllerMethods(JoinPoint joinPoint) {
        Arrays.stream(joinPoint.getArgs())
                .forEach(arg -> {
                    if(arg instanceof Company) {
                        System.out.println("*********" + ((Company) arg).getCompanyName() + "*********"  );
                    }
                });
    }

}
