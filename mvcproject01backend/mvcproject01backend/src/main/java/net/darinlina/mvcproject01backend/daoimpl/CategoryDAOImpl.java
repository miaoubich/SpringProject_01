package net.darinlina.mvcproject01backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import net.darinlina.mvcproject01backend.dao.CategoryDAO;
import net.darinline.mvcproject01backend.dto.Category;

public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		category.setId(1);
		category.setName("Food");
		category.setDescription("Bio hrana !");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		category = new Category();

		category.setId(2);
		category.setName("Drinks");
		category.setDescription("Bio drinks !");
		category.setImageURL("CAT_2.png");

		categories.add(category);

		category = new Category();

		category.setId(3);
		category.setName("Beverage");
		category.setDescription("Bio other Beverages !");
		category.setImageURL("CAT_3.png");

		categories.add(category);
	}

	@Override
	public List<Category> List() {

		return categories;
	}

}
