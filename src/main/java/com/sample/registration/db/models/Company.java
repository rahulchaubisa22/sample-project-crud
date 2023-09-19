package com.sample.registration.db.models;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "company")
public class Company implements Serializable {
    @Id
    public String id;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String companyName;
    public String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public Date getDateOfLaunching() {
        return dateOfLaunching;
    }

    public void setDateOfLaunching(Date dateOfLaunching) {
        this.dateOfLaunching = dateOfLaunching;
    }

    public String ceo;

    public Date dateOfLaunching;

}
