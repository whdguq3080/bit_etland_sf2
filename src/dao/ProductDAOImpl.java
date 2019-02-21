package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ProductDTO;
import enums.CustomerSQL;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class ProductDAOImpl implements ProductDAO {
	private static ProductDAOImpl instance = new ProductDAOImpl();
	public ProductDAOImpl() {	}
	public static ProductDAOImpl getInstance() {return instance;}

	@Override
	public void insertProduct(ProductDAO pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> selectProductlist(Proxy pxy) {
		List<ProductDTO> list = new ArrayList<>();
		try {
			 System.out.println("프러덕트 dao");
			Pagination page = ((PageProxy)pxy).getPage();
			String sql = EmployeeSQL.PRODUCT.toString();
			String startRow = String.valueOf(page.getStartRow());
			String endRow = String.valueOf(page.getEndRow());
			System.out.println("로우"+startRow+endRow);
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
			.getConnection().prepareStatement(sql);
			ps.setString(1, startRow);
			ps.setString(2, endRow);
		ResultSet rs = ps.executeQuery();
		ProductDTO pro = null;
		while (rs.next()) {
			pro = new ProductDTO();
			pro.setProductsID(rs.getString("PRODUCTS_ID"));
			pro.setRnum(rs.getString("Rnum"));
			pro.setProductName(rs.getString("PRODUCT_NAME"));
			pro.setSupplierID(rs.getString("SUPPLIER_ID"));
			pro.setCategoryID(rs.getString("CATEGORY_ID"));
			pro.setUnit(rs.getString("UNIT"));
			pro.setPrice(rs.getString("PRICE"));
			 System.out.println("방금 담은 값 :" +pro.getProductName());
			list.add(pro);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<ProductDAO> selectProduct(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDAO selectProducts(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countProduct(Proxy pxy) {
		int count = 0;
		try {
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(EmployeeSQL.PRODUCT_COUNT.toString());
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
	public boolean existsProduct(String searchword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateproduct(ProductDAO pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteproduct(ProductDAO pro) {
		// TODO Auto-generated method stub
		
	}

}
