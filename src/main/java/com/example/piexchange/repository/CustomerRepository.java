package com.example.piexchange.repository;

import com.example.piexchange.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

    Customer findByContactNo(String contactNo);

    List<Customer> findByContactNoStartingWith(String prefix);


}
