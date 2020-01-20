package net.darinlina.mvcproject01backend.dao;

import java.util.List;

import net.darinline.mvcproject01backend.dto.Category;

public interface CategoryDAO {

	boolean add(Category category);

	List<Category> List();

	Category get(int id);
}
