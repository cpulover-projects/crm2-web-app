package com.cpulover.spring.crm2webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cpulover.spring.crm2webapp.entity.Customer;
import com.cpulover.spring.crm2webapp.service.CustomerService;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject Customer Service
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model model) {
		// get customers from the DAO
		List<Customer> customerList = customerService.findAll();

		// add the result to the model
		model.addAttribute("customers", customerList);

		// return view page
		return "customer/list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String addCustomer(Model model) {
		// create model attribute to bind form data
		Customer customer = new Customer();

		// add the attribute to the model
		model.addAttribute("customer", customer);
		return "customer/customer-form";
	}

	@PostMapping("/save")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		// save customer using service
		customerService.save(customer);
		return "redirect:/customer/list"; // redirect to /customer/list method in the controller
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		// get customer by id from service
		Customer customer = customerService.findById(id);
		// set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		// send over to the form
		return "customer/customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) {
		customerService.deleteById(id);
		return "redirect:/customer/list";
	}

	@GetMapping("/search")
	public String searchCustomers(@RequestParam("name") String name, Model theModel) {

		// search customers from the service
		List<Customer> theCustomers = customerService.searchCustomers(name);

		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);

		return "customer/list-customers";
	}
}
