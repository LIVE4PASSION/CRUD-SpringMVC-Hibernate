package com.ajay.springdemo.service;

import java.util.List;

import com.ajay.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomerList();

	public void save(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}
