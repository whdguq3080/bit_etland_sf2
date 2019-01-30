package service;

import java.util.List;

import domain.CustomerDTO;


public interface CustomerService {
	public void registCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomerList(); 
	public List<CustomerDTO> retrieveCustomer(String searchWord);
	public CustomerDTO retrieveCustomers(String searchWord);
	public int countCustomer();
	public boolean existsCustomer(String searchword);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}
