package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {}
	public static EmployeeDAOImpl getInstance() {return instance;}
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	@Override
	public void insertEmployee(EmployeeDAO emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EmployeeDAO> selectEmployeesList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDAO> selectEmployees(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDAO selectEmployee(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countEmployees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsEmployee(String searchword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateEmployee(EmployeeDAO emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(EmployeeDAO emp) {
		// TODO Auto-generated method stub
		
	}

}
