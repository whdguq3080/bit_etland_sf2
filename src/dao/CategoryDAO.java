package dao;

import java.util.List;

import proxy.Proxy;

public interface CategoryDAO {
	public void insertCategorie(CategoryDAO cat);
	public List<?> selectCategorieList(Proxy pagePxy); 
	public List<CategoryDAO> selectCategorie(String searchWord);
	public CategoryDAO selectCategories(String searchWord);
	public int countCategorie(Proxy pxy);
	public boolean existsCategorie(String searchword);
	public void updateCategorie(CategoryDAO car);
	public void deleteCategorie(CategoryDAO car);
}
