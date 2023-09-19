package com.sample.registration.repository;
import com.sample.registration.db.models.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {
//    // You can define custom query methods here if needed
//    List<Company> findByName(String name);
//
//    @Query("{$and:[{'dataOfLaunch':{$gt: ?0}}, {'name':{$regex: ?1, $options: 'i'}}]}")
//    List<Company> findCustomQuery(Date dateOfLaunch, String companyName);
}