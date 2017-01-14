package com.ginee.springdemo.service;

import java.util.List;

import com.ginee.springdemo.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();

	void saveCustomer(Customer myCustomer);

	Customer getCustomer(int customer_id);

	void deleteCustomer(int customer_id);
	
}
