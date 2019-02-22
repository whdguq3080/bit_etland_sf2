package service;

import java.util.List;

import dao.CategoryDAOImpl;
import domain.CategoryDTO;
import proxy.Proxy;

public class CategoryServiceImpl implements CategoryService {
	private static CategoryServiceImpl instance = new CategoryServiceImpl();
	public CategoryServiceImpl() {
		dao = CategoryDAOImpl.getInstance();
	}	
	public static CategoryServiceImpl getInstance() {return instance;}
	CategoryDAOImpl dao;
	
	@Override
	public void registCategorie(CategoryDTO cat) {
	
	}
	@Override
	public List<CategoryDTO> bringCategorieList(Proxy pxy) {
		return dao.selectCategorieList(pxy);
	}
	@Override
	public List<CategoryDTO> retrieveCategorie(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CategoryDTO retrieveCategories(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countCategorie(Proxy pxy) {
		return dao.countCategorie(pxy);
	}
	@Override
	public boolean existsCategorie(String searchword) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void modifyCategorie(CategoryDTO cat) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeCategorie(CategoryDTO cat) {
		// TODO Auto-generated method stub
		
	}



}
