package com.srj.spring_mvc_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.srj.spring_mvc_crud.model.Customer;
import com.srj.spring_mvc_crud.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	/*SHOW REGISTRATION FORM PAGE*/
	
	@RequestMapping(value={"/showForm"})
	public String customerForm(Model model){
		
		Customer theCustomer = new Customer();			
		model.addAttribute("customer", theCustomer);		
		return "customer-form";
	}
	
	/*STORE THE DATA IN CUSTOMER TABLE*/
	
	/*@PostMapping("/saveCustomer") can used instead of @RequestMapping*/
	
	@RequestMapping(value="saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){
		
		customerService.saveCustomer(customer);
		
		return "redirect:/list";				
	}
	
	/*SHOW LIST OF CUSTOMERS*/
	
	/*@GetMapping("/list") can used instead of @RequestMapping*/
	
	@RequestMapping(value ={"/","/list"})
	public String listCustomers(Model model) {
		List<Customer> theCustomers = customerService.getCustomers();
		model.addAttribute("customers", theCustomers);
		return "list-customers";
	}
	
	/*UPDATE THE CUSTOMER*/
	
	@RequestMapping(value = "/updateForm")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		
		Customer theCustomer = customerService.getCustomer(id);	
		model.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	/* DELETE CUSTOMER */
	@RequestMapping(value = "/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		customerService.deleteCustomer(theId);
		return "redirect:/list";
	}
	
}
