package dao;

import java.util.List;

import domain.EmployeeDTO;

public interface EmployeeDAO {
	public void insertEmployee(EmployeeDTO emp);
	public List<EmployeeDAO> selectEmployeesList(); 
	public List<EmployeeDAO> selectEmployees(String searchWord);
	public EmployeeDAO selectEmployee(String searchWord);
	public int countEmployees();
	public boolean existsEmployee(String searchword);
	public void updateEmployee(EmployeeDAO emp);
	public void deleteEmployee(EmployeeDAO emp);
}
