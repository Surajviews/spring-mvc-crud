package com.srj.spring_mvc_crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srj.spring_mvc_crud.model.Customer;
import com.srj.spring_mvc_crud.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	
	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		
		customerRepository.saveCustomer(customer);
	}

	@Transactional
	@Override
	public List<Customer> getCustomers() {
		
		return customerRepository.getCustomers();
	}

	@Transactional
	@Override
	public Customer getCustomer(int id) {
		
		return customerRepository.getCustomer(id);
	}

	@Transactional
	@Override
	public void deleteCustomer(int id) {

		customerRepository.deleteCustomer(id);
		
	}

}
