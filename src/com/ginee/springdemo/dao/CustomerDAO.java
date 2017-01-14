package com.ginee.springdemo.dao;

import java.util.List;

import com.ginee.springdemo.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();

	void saveCustomer(Customer myCustomer);

	Customer getCustomer(int customer_id);

	void deleteCustomer(int customer_id);
	
}
