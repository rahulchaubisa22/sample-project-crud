package com.sample.registration.error;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomErrorResponse {
    private String error;
    private String errorDesc;

    public CustomErrorResponse(String error, String errorDesc) {
        this.error = error;
        this.errorDesc = errorDesc;
    }
}
