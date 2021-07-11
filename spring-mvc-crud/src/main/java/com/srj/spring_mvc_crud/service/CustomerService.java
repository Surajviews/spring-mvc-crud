package com.srj.spring_mvc_crud.service;

import java.util.List;

import com.srj.spring_mvc_crud.model.Customer;

public interface CustomerService {

	void saveCustomer(Customer customer);

	List<Customer> getCustomers();

	Customer getCustomer(int theId);

	void deleteCustomer(int theId);

}
