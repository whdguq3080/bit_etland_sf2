package dao;

import java.util.List;

public interface CustomerDAO {
	public void insertCustomer(CustomerDAO cus);
	public List<CustomerDAO> selectCustomerlist(); 
	public List<CustomerDAO> selectCustomer(String searchWord);
	public CustomerDAO selectCustomers(String searchWord);
	public int countCustomer();
	public boolean existsCustomer(String searchword);
	public void updateCustomer(CustomerDAO cus);
	public void deleteCustomer(CustomerDAO cus);
}
