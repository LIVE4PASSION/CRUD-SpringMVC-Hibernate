package com.ajay.springdemo.dao;

import java.util.List;

import com.ajay.springdemo.entity.Customer;

public interface CustomerDAO {
	public  List<Customer> getCustomers();

	public void save(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);


}
