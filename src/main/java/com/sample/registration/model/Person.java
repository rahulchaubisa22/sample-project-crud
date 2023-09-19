package com.sample.registration.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    public String id;
    public String firstName;
    public String middleName;
    public String lastName;
    public Long phoneNumber;
    public String email;
}
