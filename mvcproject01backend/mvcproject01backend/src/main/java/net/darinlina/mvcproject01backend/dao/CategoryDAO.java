package net.darinlina.mvcproject01backend.dao;

import java.util.List;

import net.darinline.mvcproject01backend.dto.Category;

public interface CategoryDAO {

	List<Category> List();
	CategoryDAO get(int id);
}
