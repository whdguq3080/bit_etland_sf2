package service;

import java.util.List;

import dao.CustomerDAOImpl;
import domain.CustomerDTO;

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
	public List<CustomerDTO> bringCustomerList() {
		return null;
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public CustomerDTO retrieveCustomers(CustomerDTO cus) {
		return dao.selectCustomers(cus);
	}

}
