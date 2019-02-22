package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.CategoryDTO;
import enums.CategorySQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CategoryDAOImpl implements CategoryDAO{
	public static CategoryDAOImpl instance = new CategoryDAOImpl();
	public CategoryDAOImpl() {}
	public static CategoryDAOImpl getInstance() {return instance;}
	
	@Override
	public void insertCategorie(CategoryDAO cat) {
		try {
			String sql = CategorySQL.LIST.toString();
			DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection().prepareStatement(sql);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<CategoryDTO> selectCategorieList(Proxy pxy) {
		 List<CategoryDTO> list = new ArrayList<>();
		 try {
			Pagination page = ((PageProxy)pxy).getPage();
			String sql = CategorySQL.LIST.toString();
			PreparedStatement ps=DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection().prepareStatement(sql);
			String startRow = String.valueOf(page.getStartRow());
			String endRow = String.valueOf(page.getEndRow());
			System.out.println("DAO 스타트로우" + startRow);
			System.out.println("DAO 앤드로우" + endRow);
			ps.setString(1, startRow);
			ps.setString(2, endRow);
			ResultSet rs = ps.executeQuery();
			CategoryDTO cat = null;
			while (rs.next()) {
				cat = new CategoryDTO();
				cat.setCategoryId(rs.getString("CATEGORY_ID"));
				cat.setCategoryName(rs.getString("CATEGORY_NAME"));
				cat.setDescription(rs.getString("DESCRIPTION"));
				list.add(cat);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
	}
	@Override
	public List<CategoryDAO> selectCategorie(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CategoryDAO selectCategories(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countCategorie(Proxy pxy) {
		int count = 0;
		try {
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CategorySQL.CATEGORY_COUNT.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt("COUNT");
			}
			System.out.println();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("zkzkzkzkzkzkzkzk 카운트" + count);
		return count;
	}
	@Override
	public boolean existsCategorie(String searchword) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void updateCategorie(CategoryDAO car) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteCategorie(CategoryDAO car) {
		// TODO Auto-generated method stub
		
	}
	
}
