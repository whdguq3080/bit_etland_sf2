package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class CustomerDAOImpl implements CustomerDAO {
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	private CustomerDAOImpl() {}
	public static CustomerDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void insertCustomer(CustomerDTO cus) {
		try {
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(CustomerSQL.SIGNUP.toString());
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getCustomersName());
			ps.setString(3, cus.getAddress());
			ps.setString(4, cus.getCity());
			ps.setString(5, cus.getPostalCode());
			ps.setString(6, cus.getPassword());
			ps.setString(7, cus.getSsn());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public CustomerDTO selectCustomers(CustomerDTO cus) {
		CustomerDTO dto = null;
		try {
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.SIGNIN.toString());
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new CustomerDTO();
				dto.setAddress(rs.getString("ADDRESS"));
				dto.setCity(rs.getString("CITY"));
				dto.setCustomerID(rs.getString("CUSTOMER_ID"));
				dto.setCustomersName(rs.getString("CUSTOMERS_NAME"));
				dto.setPassword(rs.getString("PASSWORD"));
				dto.setPostalCode(rs.getString("POSTALCODE"));
				dto.setSsn(rs.getString("SSN"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsCustomerID(CustomerDTO cus) {
		boolean ok = false;
		System.out.println("==커스터머 dao 진입==");
		try {
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(CustomerSQL.SIGNIN.toString());
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				ok = true;
				System.out.println("ddddd" + ok);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void updateCustomer(CustomerDAO cus) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ps.setString(1, "");
			int rs = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(CustomerDAO cus) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ps.setString(1, "");
			int rs = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
