package com.sample.registration.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Company {
    public String id;
    public String companyName;
    public Location location;
    public Person ceo;
    public Date dateOfLaunching;
}
