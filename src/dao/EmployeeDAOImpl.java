package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.EmployeeDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {}
	public static EmployeeDAOImpl getInstance() {return instance;}
	
	@Override
	public void insertEmployee(EmployeeDTO emp) {
		// 입력순서 : MANAGER,NAME,BIRTH_DATE,PHOTO,NOTES
		try {
			String sql = EmployeeSQL.REGISTER.toString();
			System.out.println("실생황 쿼리"+sql);
			Connection conn = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, emp.getManager());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getBirthDate());
			pstmt.setString(4, emp.getPhoto());
			pstmt.setString(5, emp.getNotes());
			int rs = pstmt.executeUpdate();
			System.out.println((rs==1) ? "입력성공" : "입력실패");
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	@Override
	public List<EmployeeDAO> selectEmployeesList() {
		
		return null;
	}

	@Override
	public List<EmployeeDAO> selectEmployees(String searchWord) {
		return null;
	}

	@Override
	public EmployeeDAO selectEmployee(String searchWord) {
		
		return null;
	}

	@Override
	public int countEmployees() {
		int count = 0;
		try {
			String sql = "";
			PreparedStatement ps =DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public boolean existsEmployee(EmployeeDTO emp) {
		boolean ok = false;
		try {
			PreparedStatement pstmt = 
					DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(EmployeeSQL.ACCESS.toString());
			pstmt.setString(1, emp.getEmployeesID());
			pstmt.setString(2, emp.getName());
			if(pstmt.executeQuery().next()) {
				ok= true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("접근허용 :" + ok);
		return ok; 
	}

	@Override
	public void updateEmployee(EmployeeDAO emp) {
		try {
		String sql = "";	
		PreparedStatement ps =DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection()
				.prepareStatement(sql);
				ps.setString(1, "");
				int rs = ps.executeUpdate();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	@Override
	public void deleteEmployee(EmployeeDAO emp) {
		try {
		String sql="";
		PreparedStatement ps = 
				DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection().prepareStatement(sql);
			ps.setString(1, "");
			int rs = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}		
	}
