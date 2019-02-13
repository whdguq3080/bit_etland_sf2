package dao;


import java.util.List;

import domain.CustomerDTO;
import proxy.Proxy;

public interface CustomerDAO {
	public void insertCustomer(CustomerDTO cus);
	public CustomerDTO selectCustomers(CustomerDTO cus);
	public List<CustomerDTO> selectCustomersLists(Proxy pxy);
	public int countCustomer(Proxy pxy);
	public boolean existsCustomerID(CustomerDTO cus);
	public void updateCustomer(CustomerDAO cus);
	public void deleteCustomer(CustomerDAO cus);
}
