package service;

import java.util.List;

import domain.CustomerDTO;


public interface CustomerService {
	public void registCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomerList(); 
	public CustomerDTO retrieveCustomers(CustomerDTO cus);
	public int countCustomer();
	public boolean existsCustomer(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}
