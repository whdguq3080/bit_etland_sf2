package dao;

import java.util.List;

public interface ProductDAO {
	public void insertProduct(ProductDAO pro);
	public List<ProductDAO> selectProductlist(); 
	public List<ProductDAO> selectProduct(String searchWord);
	public ProductDAO selectProducts(String searchWord);
	public int countProduct();
	public boolean existsProduct(String searchword);
	public void updateproduct(ProductDAO pro);
	public void deleteproduct(ProductDAO pro);
}
