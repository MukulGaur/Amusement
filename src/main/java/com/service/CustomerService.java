package com.service;

import java.util.List;

import com.entity.Customer;

public interface CustomerService {
	
	public Customer insertCustomer(Customer customer);
	public Customer updateCustomerById(Customer customer, int customerId);
	public String deleteCustomerById(int customerId);
	public List<Customer>getAllCustomers();
	public Customer getCustomerById(int customerId);
	
	
//	public List<Customer> viewCustomerList(String activityName);
//	public List<Customer> viewCustomerList(LocalDate date);

}
