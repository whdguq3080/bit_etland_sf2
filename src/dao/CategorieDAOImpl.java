package dao;

import java.util.List;

import service.CategorieServiceImpl;

public class CategorieDAOImpl implements CategorieDAO{
	
	private static CategorieDAOImpl instance = new CategorieDAOImpl();
	public CategorieDAOImpl() {}
	public static CategorieDAOImpl getInstance() {return instance;}
	
	@Override
	public void insertCategorie(CategorieDAO cat) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<CategorieDAO> selectCategorieList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CategorieDAO> selectCategorie(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CategorieDAO selectCategories(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countCategorie() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean existsCategorie(String searchword) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void updateCategorie(CategorieDAO car) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteCategorie(CategorieDAO car) {
		// TODO Auto-generated method stub
		
	}
	
}
