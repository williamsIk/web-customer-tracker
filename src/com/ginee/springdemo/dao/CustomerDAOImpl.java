package com.ginee.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ginee.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	//@Transactional //use to directly establish transactions without the service layer
	public List<Customer> getCustomers() {

		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//create a query
		/*Query<Customer> query =
				session.createQuery("from Customer",Customer.class);
		*/
		//create a query and sort the order
		Query<Customer> query =
				session.createQuery("from Customer order by lastName",Customer.class);
		
		
		
		//execute query and get result list
		List<Customer> customers = query.getResultList();
		
		//return the results
		
		return customers;
	}


	@Override
	public void saveCustomer(Customer myCustomer) {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
	
		/*//save the customer
		session.save(myCustomer);*/
		
		//let hibernate decide whether to use update or save 
		//it saves or updates the customer based on the primary key
		session.saveOrUpdate(myCustomer);
				
	}


	@Override
	public Customer getCustomer(int customer_id) {
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//retireve the customer using the primary key that was passed
		Customer customer =  session.get(Customer.class, customer_id);
		
		return customer;
	}


	@Override
	public void deleteCustomer(int customer_id) {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//delete object with primary key
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("delete from Customer where id=:customerId ");
		
		//set customerId to customer_id
		query.setParameter("customerId", customer_id);
		
		query.executeUpdate();
	}

}
