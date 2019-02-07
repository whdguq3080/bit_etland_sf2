package dao;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cus);
	public List<CustomerDAO> selectCustomerlist(); 
	public List<CustomerDAO> selectCustomer(String searchWord);
	public CustomerDAO selectCustomers(String searchWord);
	public int countCustomer();
	public boolean existsCustomer(CustomerDTO cus);
	public void updateCustomer(CustomerDAO cus);
	public void deleteCustomer(CustomerDAO cus);
}
