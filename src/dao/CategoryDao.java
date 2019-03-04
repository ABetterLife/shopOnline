package dao;

import java.util.List;

import domain.Category;

public interface CategoryDao {
	void addCategory(Category c);
	List<Category> findAll();
	Category findCategoryById(String category_id);

}
