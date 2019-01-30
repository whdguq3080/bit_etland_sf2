package service;

import java.util.List;

import domain.CategorieDTO;

public interface CategorieService {
	public void registCategorie(CategorieDTO cat);
	public List<CategorieDTO> bringCategorieList(); 
	public List<CategorieDTO> retrieveCategorie(String searchWord);
	public CategorieDTO retrieveCategories(String searchWord);
	public int countCategorie();
	public boolean existsCategorie(String searchword);
	public void modifyCategorie(CategorieDTO cat);
	public void removeCategorie(CategorieDTO cat);
}
