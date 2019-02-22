package service;

import java.util.List;

import domain.CategoryDTO;
import proxy.Proxy;

public interface CategoryService {
	public void registCategorie(CategoryDTO cat);
	public List<?> bringCategorieList(Proxy pagePxy); 
	public List<CategoryDTO> retrieveCategorie(String searchWord);
	public CategoryDTO retrieveCategories(String searchWord);
	public int countCategorie(Proxy pxy);
	public boolean existsCategorie(String searchword);
	public void modifyCategorie(CategoryDTO cat);
	public void removeCategorie(CategoryDTO cat);
}
