package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

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
					.prepareStatement(CustomerSQL.COUNT.toString());
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getCustomerName());
			ps.setString(3, cus.getPassword());
			ps.setString(4, cus.getSsn());
			ps.setString(5, cus.getPhone());
			ps.setString(6, cus.getPostalCode());
			ps.setString(7, cus.getCity());
			ps.setString(8, cus.getAddress());
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
				dto.setCustomerName(rs.getString("CUSTOMERS_NAME"));
				dto.setPassword(rs.getString("PASSWORD"));
				dto.setPostalCode(rs.getString("POSTALCODE"));
				dto.setSsn(rs.getString("SSN"));
				dto.setPhone(rs.getString("PHONE"));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<CustomerDTO> selectCustomersLists(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			//System.out.println("실행할 쿼리" + CustomerSQL.LIST.toString());
			Pagination page = ((PageProxy)pxy).getPage();
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.LIST.toString());
				String startRow = String.valueOf(page.getStartRow());
				String endRow = String.valueOf(page.getEndRow());
				System.out.println("DAO 스타트로우" + startRow);
				System.out.println("DAO 앤드로우" + endRow);
				ps.setString(1, startRow);
				ps.setString(2, endRow);
			ResultSet rs = ps.executeQuery();
			CustomerDTO cust = null;
			while (rs.next()) {
				  cust = new CustomerDTO();
				  cust.setCustomerID(rs.getString("CUSTOMER_ID"));
				  cust.setRnum(rs.getString("Rnum"));
	              cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
	              cust.setSsn(rs.getString("SSN"));
	              cust.setPhone(rs.getString("PHONE"));
	              cust.setCity(rs.getString("CITY"));
	              cust.setAddress(rs.getString("ADDRESS"));
	              cust.setPostalCode(rs.getString("POSTAL_CODE"));
	              System.out.println("방금 담은 값 :" +cust.getCustomerName());
	              list.add(cust);
			}
			System.out.println("1번회원: "+ list.get(0).getCustomerName());
			System.out.println("2번회원: "+ list.get(1).getCustomerName());
			System.out.println("3번회원: "+ list.get(2).getCustomerName());
			System.out.println("4번회원: "+ list.get(3).getCustomerName());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public int countCustomer(Proxy pxy) {
		int count = 0;
		try {
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.ROW_COUNT.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt("COUNT");
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
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
	@Override
	public Map<String, Object> selectPhone(Proxy pxy) {
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			PreparedStatement ps
			=DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection().prepareStatement(CustomerSQL.MEMBER.toString());
			ResultSet rs = ps.executeQuery();
			CustomerDTO cust = null;
			while(rs.next()) {
			cust = new CustomerDTO();
			String entry = rs.getString("CUSTOMER_ID");
			cust.setCustomerID(rs.getString("CUSTOMER_ID"));
			cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
			cust.setPhone(rs.getString("PHONE"));
			map.put(entry, cust);
			}
			System.out.println("=====Map===="+map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return map;
	}
	}

