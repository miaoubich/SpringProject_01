package net.darinlina.mvcproject01backend.dao;

import java.util.List;

import net.darinline.mvcproject01backend.dto.Category;

public interface CategoryDAO {

	Category get(int id);

	List<Category> List();

	boolean add(Category category);

	boolean update(Category category);

	boolean delete(Category category);

}
