package service;

import java.util.List;

import dao.ProductDAOImpl;
import domain.ProductDTO;
import proxy.Proxy;

public class ProductServiceImpl implements ProductService{
	private static ProductServiceImpl instance = new ProductServiceImpl();
	public ProductServiceImpl() {dao = ProductDAOImpl.getInstance();}
	
	public static ProductServiceImpl getInstance() {return instance;}
	ProductDAOImpl dao;
	@Override
	public void registProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductDTO> bringProductList(Proxy pxy) {
		return dao.selectProductlist(pxy);
	}

	@Override
	public List<ProductDTO> retrieveProduct(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO retrieveProducts(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countProduct(Proxy pxy) {
		return dao.countProduct(pxy);
	}

	@Override
	public boolean existsProduct(String searchword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}

}
