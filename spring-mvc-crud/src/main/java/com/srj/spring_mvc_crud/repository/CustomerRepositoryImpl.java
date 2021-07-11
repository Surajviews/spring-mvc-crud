package com.srj.spring_mvc_crud.repository;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.srj.spring_mvc_crud.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	@Override
	public void saveCustomer(Customer customer) {
		sessionFactory.getCurrentSession().saveOrUpdate(customer);
		
	}

	@Transactional
	@Override
	public List<Customer> getCustomers() {
		
		String hql = "from customer order by customer_id";
		
		@SuppressWarnings("unchecked")
		Query<Customer> query=sessionFactory.getCurrentSession().createQuery(hql);
		List<Customer> list = query.list();
		return !list.isEmpty() ? list : null;
	}

	@Transactional
	@Override
	public Customer getCustomer(int id) {
		
		Customer customer = sessionFactory.getCurrentSession().get(Customer.class, id);
		return customer;
	}

	@Transactional
	@Override
	public void deleteCustomer(int id) {
		
		Query<?> query = sessionFactory.getCurrentSession()
								.createQuery("delete from customer where customer_id =:c_id");
		query.setParameter("c_id", id);
		int status = query.executeUpdate();
		//return status > 0 ? true : false;
		
		
		/*THIS CODE IS ALSO WORK*/
		/*Session session = sessionFactory.getCurrentSession();
		Customer customer = session.byId(Customer.class).load(id);
		session.delete(customer);*/
		
	}

	
	
	
	
}
