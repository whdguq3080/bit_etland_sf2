package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class CustomerDAOImpl implements CustomerDAO{
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	public CustomerDAOImpl() {	}
	public static CustomerDAOImpl getInstance() {return instance;}

	

	@Override
	public void insertCustomer(CustomerDTO cus) {
		try {
			PreparedStatement ps = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection()
				.prepareStatement(CustomerSQL.SIGNUP.toString());
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getCustomersName());
			ps.setString(3, cus.getAddress());
			ps.setString(4, cus.getCity());
			ps.setString(5, cus.getPostalCode());
			ps.setString(6, cus.getPassword());
			ps.setString(7, cus.getSsn());
			int rs = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomerDAO> selectCustomerlist() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDAO> selectCustomer(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDAO selectCustomers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCustomer(CustomerDTO cus) {
		boolean ok = false;
		System.out.println("==커스터머 dao 진입==");
		try {
			PreparedStatement ps=DatabaseFactory.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.SIGNIN.toString());
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ok = true;
				System.out.println("ddddd"+ok);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}

	@Override
	public void updateCustomer(CustomerDAO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(CustomerDAO cus) {
		// TODO Auto-generated method stub
		
	}

}
