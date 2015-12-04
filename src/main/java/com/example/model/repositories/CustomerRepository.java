package com.example.model.repositories;

import java.util.List;
import com.example.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	/*
	public Customer findByFirstName(String firstName);
	public List<Customer> findByLastName(String lastName);
	*/
}
