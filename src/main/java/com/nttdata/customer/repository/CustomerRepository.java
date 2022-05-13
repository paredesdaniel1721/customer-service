package com.nttdata.customer.repository;

import com.nttdata.customer.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, String> {
}
