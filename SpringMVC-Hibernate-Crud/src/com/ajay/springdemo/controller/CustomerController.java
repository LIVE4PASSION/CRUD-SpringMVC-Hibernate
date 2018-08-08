package com.ajay.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ajay.springdemo.entity.Customer;
import com.ajay.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		List<Customer> theCustomers = customerService.getCustomerList();
		theModel.addAttribute("customers", theCustomers);
		for (Customer t : theCustomers) {
			System.out.println(t);
		}
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
	
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);	
		return "customer-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showUpdate(@RequestParam("customerId") int theId, Model theModel){
		Customer customer= customerService.getCustomer(theId);
		theModel.addAttribute("customer", customer);
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("customerId") int theId, Model theModel){
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	

	@PostMapping("/saveCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer theCustomer){
		
		customerService.save(theCustomer);
		return "redirect:/customer/list";
		
	}
}
