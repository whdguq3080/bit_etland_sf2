package dao;

import java.util.List;

public class ProductDAOImpl implements ProductDAO {
	private static ProductDAOImpl instance = new ProductDAOImpl();
	public ProductDAOImpl() {	}
	public static ProductDAOImpl getInstance() {return instance;}

	@Override
	public void insertProduct(ProductDAO pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDAO> selectProductlist() {
		// TODO Auto-generated method stub
		return null;
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
	public int countProduct() {
		// TODO Auto-generated method stub
		return 0;
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
