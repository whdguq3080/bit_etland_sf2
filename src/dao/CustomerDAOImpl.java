package dao;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO{
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	public CustomerDAOImpl() {	}
	public static CustomerDAOImpl getInstance() {return instance;}

	

	@Override
	public void insertCustomer(CustomerDAO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CustomerDAO> selectCustomerlist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDAO> selectCustomer(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDAO selectCustomers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCustomer(String searchword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCustomer(CustomerDAO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(CustomerDAO cus) {
		// TODO Auto-generated method stub
		
	}

}
