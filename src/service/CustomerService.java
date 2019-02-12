package service;

import java.util.List;

import domain.CustomerDTO;
import proxy.Pagination;


public interface CustomerService {
	public void registCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomerList(Pagination page); 
	public CustomerDTO retrieveCustomers(CustomerDTO cus);
	public int countCustomer();
	public boolean existsCustomer(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}
