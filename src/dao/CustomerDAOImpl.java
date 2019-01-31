package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import domain.CustomerDTO;
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
			String sql = String.format(EmployeeSQL.COUNT.toString(),cus.getCustomerID()
					,cus.getCustomersName());
			System.out.println("실생황 쿼리"+sql);
			Connection conn = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cus.getCustomerID());
			pstmt.setString(2, cus.getCustomersName());
			int rs = pstmt.executeUpdate();
			System.out.println((rs==1) ? "입력성공" : "입력실패");
		}catch(Exception e) {
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
	public boolean existsCustomer(String searchword) {
		// TODO Auto-generated method stub
		return false;
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
