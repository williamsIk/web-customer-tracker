package com.ginee.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ginee.springdemo.dao.CustomerDAO;
import com.ginee.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer myCustomer) {
		
		customerDAO.saveCustomer(myCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customer_id) {
		
		return customerDAO.getCustomer(customer_id);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customer_id) {
		customerDAO.deleteCustomer(customer_id);
		
	}

}
