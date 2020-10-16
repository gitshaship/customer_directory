package com.example.piexchange;

import com.example.piexchange.dto.CustomerDTO;
import com.example.piexchange.model.Customer;
import com.example.piexchange.service.CustomerService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@Test
	public void testCustomerCreation(){
		String name = "Aurora Collins";
		String contactNo = "89171829718";
		CustomerDTO dto = new CustomerDTO(name, contactNo);
		System.out.println("*************Test customer creation**************************");
		Assert.assertTrue(customerService.createCustomer(dto));
		List<Customer> customers = customerService.findByNumber(contactNo);
		for(Customer cus: customers){
			System.out.println("Customer Name: "+ cus.getName()+" Contact No: "+cus.getContactNo());
		}
		System.out.println("**********************************************************************");

	}

	@Test
	public void testFindByNumber(){
		String name = "Normad Collins";
		String contactNo = "67890678124";
		CustomerDTO dto = new CustomerDTO(name, contactNo);
		Assert.assertTrue(customerService.createCustomer(dto));
		List<Customer> customers = customerService.findByNumber("6789");
		System.out.println("*************Test customer list starting with given number**************************");
		for(Customer cus: customers){
			System.out.println("Customer Name: "+ cus.getName()+" Contact No: "+cus.getContactNo());
		}
		System.out.println("**********************************************************************");

	}

}
