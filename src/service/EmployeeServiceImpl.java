package service;

import java.util.List;

import dao.EmployeeDAOImpl;
import domain.EmployeeDTO;

public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeServiceImpl instance = new EmployeeServiceImpl();
	public EmployeeServiceImpl() {
		dao = EmployeeDAOImpl.getInstance();
	}
	public static EmployeeServiceImpl getInstance() {return instance;}
	EmployeeDAOImpl dao;
	
	@Override
	public void registEmployee(EmployeeDTO emp) {
		dao.insertEmployee(emp);
	}

	@Override
	public List<EmployeeDTO> bringEmployeesList() {
		return null;
		
	}

	@Override
	public List<EmployeeDTO> retrieveEmployees(String searchWord) {
		return null;
		
	}

	@Override
	public EmployeeDTO retrieveEmployee(String searchWord) {
		return null;
		
	}

	@Override
	public int countEmployees() {
		return dao.countEmployees();
	}

	@Override
	public boolean existsEmployee(String searchword) {
		return dao.existsEmployee(searchword);
	}

	@Override
	public void modifyEmployee(EmployeeDTO emp) {

		return ;
	}

	@Override
	public void removeEmployee(EmployeeDTO emp) {
		
		return ;
	}

}
