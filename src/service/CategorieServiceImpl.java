package service;

import java.util.List;

import dao.CategorieDAOImpl;
import domain.CategorieDTO;

public class CategorieServiceImpl implements CategorieService {
	private static CategorieServiceImpl instance = new CategorieServiceImpl();
	public CategorieServiceImpl() {
		dao = CategorieDAOImpl.getInstance();
	}	
	public static CategorieServiceImpl getInstance() {return instance;}
	CategorieDAOImpl dao;
	@Override
	public void registCategorie(CategorieDTO cat) {
	
	}
	@Override
	public List<CategorieDTO> bringCategorieList() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<CategorieDTO> retrieveCategorie(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CategorieDTO retrieveCategories(String searchWord) {
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
	public void modifyCategorie(CategorieDTO cat) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeCategorie(CategorieDTO cat) {
		// TODO Auto-generated method stub
		
	}



}
