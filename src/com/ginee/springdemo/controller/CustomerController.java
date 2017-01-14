package com.ginee.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ginee.springdemo.entity.Customer;
import com.ginee.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	/*@Autowired
	private CustomerDAO customerDAO;*///without service layer
	
	@Autowired
	private CustomerService customerService;
	
	//@RequestMapping("path='/list',method='Get'")||@RequestMapping("Path='/list',method='Post'")
	//@RequestMapping("/list")
	@GetMapping("/list")//only support Get requests
	//@PostMapping("/list")//only support Post requests
	public String listCustomers(Model model) {
		
		/*//get customers from the dao
				List<Customer> customers = customerDAO.getCustomers();
		*/
		//get customers from the service
		List<Customer> customers = customerService.getCustomers();
		
		//add the customers to the model
		model.addAttribute("customers", customers);
		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		//create new model attribute to bind form data
		Customer mycustomer = new Customer();
		
		model.addAttribute("customer", mycustomer);
		
		return "customer-form";
		
	} 
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer myCustomer) {
		
		//save the customer using the service
		customerService.saveCustomer(myCustomer);
		
		//pass back to the existing customer/list 
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int customer_id,
									Model model) {
		//get the customer from the service
		Customer thecustomer = customerService.getCustomer(customer_id);
		
		//set customer as a model attribute to pre-populate the form
		model.addAttribute("customer",thecustomer);
		//send over to the form
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int customer_id) {
		
		customerService.deleteCustomer(customer_id);
		
		
		return "redirect:/customer/list";
	}
	
}
