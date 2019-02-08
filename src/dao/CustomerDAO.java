package dao;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cus);
	public CustomerDTO selectCustomers(CustomerDTO cus);
	public int countCustomer();
	public boolean existsCustomerID(CustomerDTO cus);
	public void updateCustomer(CustomerDAO cus);
	public void deleteCustomer(CustomerDAO cus);
}
