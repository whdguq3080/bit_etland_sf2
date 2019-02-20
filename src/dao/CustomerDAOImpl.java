package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import domain.ImageDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.ImageProxy;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CustomerDAOImpl implements CustomerDAO {
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	Connection conn;
	public CustomerDAOImpl() {
		conn = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection();
	}
	
	
	public static CustomerDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void insertCustomer(CustomerDTO cus) {
		try {
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(CustomerSQL.SIGNUP.toString());
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getCustomerName());
			ps.setString(3, cus.getPassword());
			ps.setString(4, cus.getSsn());
			ps.setString(5, cus.getPhone());
			ps.setString(6, cus.getCity());
			ps.setString(7, cus.getAddress());
			ps.setString(8, cus.getPostalCode());
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
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.SIGNIN.toString());
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				dto = new CustomerDTO();
				dto.setCustomerID(rs.getString("CUSTOMER_ID"));
				dto.setPassword(rs.getString("PASSWORD"));
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
	public void updateCustomer(CustomerDTO cus) {
		try {
			String sql = CustomerSQL.CUST_UPDATE.toString();
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ps.setString(1, cus.getPhone());
			ps.setString(2, cus.getCity());
			ps.setString(3, cus.getAddress());
			ps.setString(4, cus.getPostalCode());
			ps.setString(5, cus.getPassword());
			ps.setString(6, cus.getCustomerID());
			int rs = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(CustomerDTO cus) {
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
	@Override
	public CustomerDTO selectCustomer(CustomerDTO cus) {
		CustomerDTO cust1 = new CustomerDTO();
		try {
			String sql = (cus.getPassword() == null) ?
					 CustomerSQL.RETRIEVE_INFO.toString() :
					 CustomerSQL.SIGNIN.toString() ;
					 CustomerSQL.CUST_UPDATE.toString();
			PreparedStatement ps
			=DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection().prepareStatement(sql);
			ps.setString(1, cus.getCustomerID());
			if(cus.getPassword() != null) {
				ps.setString(2, cus.getPassword());
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			cust1.setCustomerID(rs.getString("CUSTOMER_ID"));
			cust1.setCustomerName(rs.getString("CUSTOMER_NAME"));
			cust1.setPassword(rs.getString("PASSWORD"));
			cust1.setSsn(rs.getString("SSN"));
			cust1.setPhone(rs.getString("PHONE"));
			cust1.setPostalCode(rs.getString("POSTAL_CODE"));
			cust1.setCity(rs.getString("CITY"));
			cust1.setAddress(rs.getString("ADDRESS"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("조회된 결과"+ cust1.toString());
		return cust1;
	}
	public Map<String, Object> selectProfile(Proxy pxy) {
		CustomerDTO cust = new CustomerDTO();
		ImageDTO img = new ImageDTO();
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			String sql = "";
			ImageProxy ipxy = (ImageProxy)pxy;
			ImageDAOImpl
			.getInstance()
			.insertImage(ipxy.getImg());
			
			String imgSeq =ImageDAOImpl.getInstance().lastImageSeq();
			sql = "UPDATE CUSTOMERS SET PHOTO = ? WHERE CUSTOMER_ID LIKE ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, imgSeq);
			ps.setString(2, ipxy.getImg().getOwner());
			cust.setCustomerID(ipxy.getImg().getOwner());
			cust = selectCustomer(cust);
			img = ImageDAOImpl
					.getInstance()
					.selectImage(cust);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		map.put("img",img);
		map.put("cust",cust);
		return map;
	}
	
	}

