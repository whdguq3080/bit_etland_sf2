package dao;

import java.util.List;

public interface CategorieDAO {
	public void insertCategorie(CategorieDAO cat);
	public List<CategorieDAO> selectCategorieList(); 
	public List<CategorieDAO> selectCategorie(String searchWord);
	public CategorieDAO selectCategories(String searchWord);
	public int countCategorie();
	public boolean existsCategorie(String searchword);
	public void updateCategorie(CategorieDAO car);
	public void deleteCategorie(CategorieDAO car);
}
