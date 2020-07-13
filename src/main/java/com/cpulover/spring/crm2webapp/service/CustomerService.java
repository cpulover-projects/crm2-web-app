package com.cpulover.spring.crm2webapp.service;

import java.util.List;

import com.cpulover.spring.crm2webapp.entity.Customer;

public interface CustomerService {
	public List<Customer> findAll();

	public Customer findById(int theId);

	public void save(Customer theCustomer);

	public void deleteById(int theId);
	
	public List<Customer> searchCustomers(String name);
}
