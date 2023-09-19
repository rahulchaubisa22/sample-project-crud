package com.sample.registration.repository;
import com.sample.registration.db.models.Company;
import com.sample.registration.db.models.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
    // You can define custom query methods here if needed
}