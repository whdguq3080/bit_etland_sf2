package dao;

import java.util.List;

import domain.ProductDTO;
import proxy.Proxy;

public interface ProductDAO {
	public void insertProduct(ProductDAO pro);
	public List<ProductDTO> selectProductlist(Proxy pxy); 
	public List<ProductDAO> selectProduct(String searchWord);
	public ProductDAO selectProducts(String searchWord);
	public int countProduct(Proxy pxy);
	public boolean existsProduct(String searchword);
	public void updateproduct(ProductDAO pro);
	public void deleteproduct(ProductDAO pro);
}
