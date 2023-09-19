package com.sample.registration.services;

import com.sample.registration.model.Company;
import com.sample.registration.repository.CompanyRepository;
import com.sample.registration.repository.LocationRepository;
import com.sample.registration.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    private final CompanyRepository companyRepository;
    @Autowired
    public LocationRepository locationRepository;
    @Autowired
    public PersonRepository personRepository;

    public RegistrationService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    public Company saveCompanyDetail(Company company) {
        ModelMapper modelMapper = new ModelMapper();
        com.sample.registration.db.models.Person dbPerson =  modelMapper.map(company.getCeo(), com.sample.registration.db.models.Person.class);
        com.sample.registration.db.models.Location dbLocation =  modelMapper.map(company.getLocation(), com.sample.registration.db.models.Location.class);
        com.sample.registration.db.models.Company dbCompany =  modelMapper.map(company, com.sample.registration.db.models.Company.class);

        dbCompany.setLocation(this.locationRepository.save(dbLocation).getId());
        dbCompany.setCeo(this.personRepository.save(dbPerson).getId());

        this.companyRepository.save(dbCompany);
        return company;
    }
}
