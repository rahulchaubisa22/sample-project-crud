package com.sample.registration.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    public String id;
    public String addressLine1;
    public String addressLine2;
    public String city;
    public String state;
    public String zipcode;
}
