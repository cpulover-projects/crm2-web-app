package com.cpulover.spring.crm2webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpulover.spring.crm2webapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByFirstnameLike(String name);

}
