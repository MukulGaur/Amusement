package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Customer;
import com.repository.CustomerRepository;
import com.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public Customer insertCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public Customer updateCustomerById(Customer customer, int customerId) {
		
		Customer existingCustomer = customerRepo.findById(customerId).orElseThrow();
		
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setUsername(customer.getUsername());
		existingCustomer.setPassword(customer.getPassword());
		existingCustomer.setMobileNumber(customer.getMobileNumber());
		existingCustomer.setEmail(customer.getEmail());
		
		customerRepo.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public String deleteCustomerById(int customerId) {
		customerRepo.findById(customerId).orElseThrow();
		customerRepo.deleteById(customerId);
		return "Deleted";
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return customerRepo.findById(customerId).orElseThrow();
	}

}
