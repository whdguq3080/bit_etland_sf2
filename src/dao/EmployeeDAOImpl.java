package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			String sql = String.format(EmployeeSQL.REGISTER.toString(),emp.getManager()
					,emp.getName(),emp.getBirthDate()
					,emp.getPhoto(),emp.getNotes());
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
