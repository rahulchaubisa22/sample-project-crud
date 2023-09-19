package com.sample.registration.repository;
import com.sample.registration.db.models.Company;
import com.sample.registration.db.models.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    // You can define custom query methods here if needed
}