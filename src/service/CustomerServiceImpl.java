package service;


import java.util.List;
import java.util.Map;

import dao.CustomerDAOImpl;
import domain.CustomerDTO;
import proxy.Proxy;

public class CustomerServiceImpl implements CustomerService {
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	private CustomerServiceImpl() {
		dao = CustomerDAOImpl.getInstance();
		}
	public static CustomerServiceImpl getInstance() {return instance;}
	CustomerDAOImpl dao;
	
	@Override
	public void registCustomer(CustomerDTO cus) {
			dao.insertCustomer(cus);
	}
	@Override
	public CustomerDTO retrieveCustomers(CustomerDTO cus) {
		return dao.selectCustomers(cus);
	}
	@Override
	public List<CustomerDTO> bringCustomerList(Proxy pxy) {
		
		return dao.selectCustomersLists(pxy);
	}

	@Override
	public int countCustomer(Proxy pxy) {
		return dao.countCustomer(pxy);
	}

	public boolean existsCustomer(CustomerDTO cus) {
	
		return 	dao.existsCustomerID(cus);
	}

	@Override
	public void modifyCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		
	}
	@Override
	public CustomerDTO retrieveCustomer(CustomerDTO cus) {
		return dao.selectCustomer(cus);
	}
	@Override
	public Map<String, Object> retrievePhone(Proxy pxy) {
		return dao.selectPhone(pxy);
	}

}
