package com.example.piexchange.service;

import com.example.piexchange.dto.CustomerDTO;
import com.example.piexchange.model.Customer;
import com.example.piexchange.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Boolean createCustomer(CustomerDTO customerDTO) {
        String name = customerDTO.getName();
        String contactNo = customerDTO.getContactNo();

        // validate contact no
        Pattern patternNo = Pattern.compile("^\\d{11}$");
        // validate name - only alphabetic charactors and spaces are valid
        Pattern patternName = Pattern.compile("^[ A-Za-z]+$");


        if (!patternNo.matcher(contactNo).matches() || !patternName.matcher(name).matches()) {
            return false;

        }

        Customer customer = new Customer(name, contactNo);
        customerRepository.save(customer);
        return true;
    }

    public List<Customer> findByNumber(String number) {
        List<Customer> customerList = customerRepository.findByContactNoStartingWith(number);
        return customerList;
    }

    /*
    Assuming only one customer can exist for one contact no, the number should not already exist
     */
    public Boolean doesNumberExist(String number) {
        Customer customer = customerRepository.findByContactNo(number);
        return customer != null;

    }

}
