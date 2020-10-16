package com.example.piexchange.controllers;

import com.example.piexchange.dto.CustomerDTO;
import com.example.piexchange.model.Customer;
import com.example.piexchange.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDTO request) {
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        if (customerService.doesNumberExist(request.getContactNo())) {
            return ResponseEntity.badRequest().body("Number already exists");
        } else {
            if (customerService.createCustomer(request)) {
                return ResponseEntity.ok().body("Created Successfully");
            } else {
                return ResponseEntity.badRequest().body("bad request");
            }
        }
    }


    @RequestMapping(value = "/customer", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Object> findCustomersByContactNo(@RequestParam(value = "number") String number) {
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        List<Customer> customerList = customerService.findByNumber(number);
        if (customerList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(customerList);
        }
    }

}
