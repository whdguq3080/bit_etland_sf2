package service;

import java.util.List;

import dao.CustomerDAOImpl;
import domain.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
	private static CustomerServiceImpl Instance = new CustomerServiceImpl();
	public CustomerServiceImpl() {
		dao = CustomerDAOImpl.getInstance();
		}
	public static CustomerServiceImpl getInstance() {return Instance;}
	CustomerDAOImpl dao;
	@Override
	public void registCustomer(CustomerDTO cus) {
		dao.insertCustomer(cus);
	}

	@Override
	public List<CustomerDTO> bringCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> retrieveCustomer(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO retrieveCustomers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean existsCustomer(CustomerDTO cus) {
	
		return 	dao.existsCustomer(cus);
	}

	@Override
	public void modifyCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}
	

}
